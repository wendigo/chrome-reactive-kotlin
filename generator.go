package main

import (
	"encoding/json"
	"flag"
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"path/filepath"
	"strings"

	"bytes"
	"github.com/aymerick/raymond"
	"regexp"
	"sort"
)

type Protocol struct {
	Version Version  `json:"version,omitempty"`
	Domains []Domain `json:"domains,omitempty"`
}

type EventMapping struct {
	EventName string
	Class     string
}

func (p Protocol) EventMappings() []EventMapping {
	mappings := make(map[string]string)

	for _, domain := range p.Domains {
		for _, event := range domain.Events {
			if event.HasReturnValue() {
				mappings[fmt.Sprintf("%s.%s", domain.Name, event.Name)] = fmt.Sprintf("%s.domain.%s.%s", basePackage, domain.LowerName(), event.ClassName())
			} else {
				mappings[fmt.Sprintf("%s.%s", domain.Name, event.Name)] = fmt.Sprintf("%s.%s", basePackage, "ProtocolEvent")
			}
		}
	}

	retval := make([]EventMapping, 0)

	for event, class := range mappings {
		retval = append(retval, EventMapping{
			EventName: event,
			Class:     class,
		})
	}

	sort.Slice(retval, func(i, j int) bool {
		return retval[i].EventName < retval[j].EventName
	})

	return retval
}

type Version struct {
	Major string `json:"major,omitempty"`
	Minor string `json:"minor,omitempty"`
}

type Domain struct {
	Name         string    `json:"domain,omitempty"`
	Experimental bool      `json:"experimental,omitempty"`
	Types        []Type    `json:"types"`
	Commands     []Command `json:"commands,omitempty"`
	Events       []Event   `json:"events,omitempty"`
	Dependencies []string  `json:"dependencies,omitempty"`
	Description  string    `json:"description,omitempty"`
	Deprecated   bool      `json:"deprecated,omitempty"`
}

func (d Domain) LowerName() string {
	return strings.ToLower(d.Name)
}

func (d Domain) UpperName() string {
	return strings.ToUpper(d.Name)
}

type Type struct {
	Id           string      `json:"id,omitempty"`
	Type         string      `json:"type,omitempty"`
	Enum         []string    `json:"enum,omitempty"`
	Description  string      `json:"description,omitempty"`
	Properties   []Parameter `json:"properties,omitempty"`
	Experimental bool        `json:"experimental,omitempty"`
	Items        *RefItem    `json:"items,omitempty"`
	MaxItems     uint        `json:"maxItems,omitempty"`
	MinItems     uint        `json:"minItems,omitempty"`
}

func (t Type) HasProperties() bool {
	return len(t.Properties) > 0
}

func (t Type) IsEnum() bool {
	return len(t.Enum) > 0
}

type Command struct {
	Name         string      `json:"name,omitempty"`
	Description  string      `json:"description,omitempty"`
	Returns      []Parameter `json:"returns,omitempty"`
	Parameters   []Parameter `json:"parameters,omitempty"`
	Experimental bool        `json:"experimental,omitempty"`
	Redirect     string      `json:"redirect,omitempty"`
	Handlers     []string    `json:"handlers,omitempty"`
	Deprecated   bool        `json:"deprecated,omitempty"`
}

func (c Command) SimpleName() string {
	return strings.Title(c.Name)
}

func (c Command) ClassName() string {
	return c.SimpleName() + "Response"
}

func (c Command) InputDataClass() string {
	if !c.HasInputParams() {
		return ""
	}

	template, err := readTemplate("input_data_class")
	if err != nil {
		log.Panicf("Could not render template: %s", err)
	}

	return raymond.MustRender(template, c)

}

func (c Command) OutputDataClass() string {
	if !c.HasReturnValue() {
		return ""
	}

	template, err := readTemplate("output_data_class")
	if err != nil {
		log.Panicf("Could not render template: %s", err)
	}

	return raymond.MustRender(template, struct {
		Type Command
		Description string
	}{Type: c, Description: fmt.Sprintf("Represents response frame for %s.%s method call.", currentDomain, c.Name)})
}

func (c Command) HasReturnValue() bool {
	return len(c.Returns) > 0
}

func (c Command) HasInputParams() bool {
	return len(c.Parameters) > 0
}

type RefItem struct {
	Reference   string   `json:"$ref,omitempty"`
	Type        string   `json:"type,omitempty"`
	Enum        []string `json:"enum,omitempty"`
	Description string   `json:"description,omitempty"`
}

type Parameter struct {
	Name         string   `json:"name,omitempty"`
	Type         string   `json:"type,omitempty"`
	Description  string   `json:"description,omitempty"`
	Reference    string   `json:"$ref,omitempty"`
	Optional     bool     `json:"optional,omitempty"`
	Enum         []string `json:"enum,omitempty"`
	Experimental bool     `json:"experimental,omitempty"`
	Deprecated   bool     `json:"deprecated,omitempty"`
	Items        *RefItem `json:"items,omitempty"`
	MinItems     uint     `json:"minItems,omitempty"`
	MaxItems     uint     `json:"maxItems,omitempty"`
}

func sanitizeReference(ref string) string {
	parts := strings.Split(ref, ".")

	if len(parts) == 1 {
		return ref
	}

	return fmt.Sprintf("%s.domain.%s.%s", basePackage, strings.ToLower(parts[0]), parts[1])
}

func (p Parameter) ReferenceImport() string {
	var ref string = ""

	if p.Reference != "" {
		ref = p.Reference
	}

	if p.Items != nil && p.Items.Reference != "" {
		ref = p.Items.Reference
	}

	parts := strings.Split(ref, ".")

	if len(parts) == 2 {
		return fmt.Sprintf("%s.%s", strings.ToLower(parts[0]), parts[1])
	}

	return ""
}

func (p Parameter) GetFormattedType() string {

	if p.Reference != "" {
		return sanitizeReference(p.Reference)
	}

	if p.Type != "" {
		switch p.Type {
		case "string":
			return "String"
		case "boolean":
			return "Boolean"
		case "integer":
			return "Int"
		case "number":
			return "Double"
		case "array":
			return fmt.Sprintf("List<%s>", p.GetParameterArrayType())
		case "object":
			return "String"
		case "any":
			return "Any"
		default:
			panic("Unknown type " + p.Type)
		}
	}

	return fmt.Sprintf("UnknownType<%v>", p)
}

func (p Parameter) GetParameterArrayType() string {
	if p.Items != nil && p.Items.Reference != "" {
		return sanitizeReference(p.Items.Reference)
	}

	if p.Items.Type != "" {
		switch p.Items.Type {
		case "string":
			return "String"
		case "boolean":
			return "Boolean"
		case "integer":
			return "Int"
		case "any":
			return "Any"
		case "object":
			return "Any"
		case "number":
			return "Double"
		}
	}

	return fmt.Sprintf("UnknownType<%v>", p)
}

func (t Type) GetFormattedType() string {
	if t.Type != "" {
		switch t.Type {
		case "string":
			return "String"
		case "boolean":
			return "Bool"
		case "integer":
			return "Int"
		case "number":
			return "Double"
		case "array":
			return fmt.Sprintf("List<%s>", t.GetParameterArrayType())
		case "object":
			return "String"
		case "any":
			return "Any"
		default:
			panic("Unknown type " + t.Type)
		}
	}

	return fmt.Sprintf("UnknownType<%v>", t)
}

func (t Type) GetParameterArrayType() string {
	if t.Items != nil && t.Items.Reference != "" {
		return sanitizeReference(t.Items.Reference)
	}

	if t.Items.Type != "" {
		switch t.Items.Type {
		case "string":
			return "String"
		case "boolean":
			return "Bool"
		case "integer":
			return "Int"
		case "number":
			return "Double"
		case "any":
			return "Any"
		case "object":
			return "Object"
		}
	}

	return fmt.Sprintf("UnknownType<%v>", t)
}

type Event struct {
	Name         string      `json:"name,omitempty"`
	Description  string      `json:"description,omitempty"`
	Returns      []Parameter `json:"parameters,omitempty"`
	Experimental bool        `json:"experimental,omitempty"`
}

func (e Event) OutputDataClass() string {
	if !e.HasReturnValue() {
		return ""
	}

	template, err := readTemplate("output_data_class")
	if err != nil {
		log.Panicf("Could not render template: %s", err)
	}

	return raymond.MustRender(template, struct {
		Type Event
		Description string
	}{Type: e, Description: fmt.Sprintf("Represents event frames for %s.%s", currentDomain, e.Name)})
}

func (e Event) SimpleName() string {
	return strings.Title(e.Name)
}

func (e Event) HasReturnValue() bool {
	return len(e.Returns) > 0
}

func (e Event) ClassName() string {
	return e.SimpleName() + "Event"
}

func (e Event) ImplementingInterfaces() []string {
	return []string{fmt.Sprintf("%s.ProtocolEvent(domain = \"%s\", name = \"%s\")", basePackage, currentDomain, e.Name)}
}

var protocolFile string
var basePackage string
var kotlinBase string
var currentDomain string

func init() {
	flag.StringVar(&protocolFile, "protocol-file", "protocol.json", "")
	flag.StringVar(&basePackage, "base-package", "pl.wendigo.chrome", "")
	flag.StringVar(&kotlinBase, "kotlin-base", "src/main/kotlin", "")
}

func kotlinFilename(pkg string) string {
	fullpath := fmt.Sprintf("%s/%s/%s.kt", kotlinBase, strings.Replace(basePackage, ".", "/", -1), pkg)

	dir := filepath.Dir(fullpath)
	log.Printf("Creating dir: %s for %s", dir, pkg)

	err := os.MkdirAll(dir, 0700)
	if err != nil {
		log.Fatalf("Could not create dir: %s: %s", dir, err)
	}

	return fullpath
}

var camelRegex = regexp.MustCompile("[0-9A-Za-z]+")

func EnumName(src string) string {
	byteSrc := []byte(src)
	chunks := camelRegex.FindAll(byteSrc, -1)
	for idx, val := range chunks {
		chunks[idx] = bytes.ToUpper(val)
	}
	return string(bytes.Join(chunks, []byte("_")))
}

func readTemplate(name string) (string, error) {
	bytes, err := ioutil.ReadFile("generator_templates/" + name + ".hbs")
	return string(bytes), err
}

func generateAndWrite(filename, tpl string, ctx interface{}) error {
	template, err := readTemplate(tpl)
	if err != nil {
		return err
	}

	content := raymond.MustRender(template, ctx)

	if err := ioutil.WriteFile(filename, []byte(content), 0700); err != nil {
		return err
	}

	return nil
}

func main() {
	flag.Parse()

	file, err := os.Open(protocolFile)
	if err != nil {
		log.Panicf("Could not open file: %v", file)
	}

	protocol := &Protocol{}

	if err := json.NewDecoder(file).Decode(protocol); err != nil {
		log.Panicf("Could not read json: %s", err)
	}

	raymond.RegisterHelper("value", func(name string, options *raymond.Options) string {
		switch name {
		case "this":
			return "@get:com.fasterxml.jackson.annotation.JsonProperty(\"this\") val _this"
		case "object":
			return "@get:com.fasterxml.jackson.annotation.JsonProperty(\"object\") val _object"
		}

		return fmt.Sprintf("val %s", name)
	})

	raymond.RegisterHelper("Package", func(options *raymond.Options) string {
		return basePackage
	})

	raymond.RegisterHelper("Domain", func(options *raymond.Options) string {
		return currentDomain
	})

	raymond.RegisterHelper("EnumName", func(value string, options *raymond.Options) string {
		switch value {
		case "Infinity":
			return "PLUS_INFINITY"
		case "-Infinity":
			return "MINUS_INFINITY"
		case "-0":
			return "ZERO"
		}

		return EnumName(value)
	})

	log.Println("Generating protocol class")

	if err := generateAndWrite(kotlinFilename("ChromeProtocol"), "protocol_class", struct {
		Protocol Protocol
	}{
		Protocol: *protocol,
	}); err != nil {
		log.Panicf("Could not generate file: %s", err)
	}

	for _, domain := range protocol.Domains {
		log.Printf("Generating classes for domain: %s in %s", domain.Name, basePackage)

		currentDomain = domain.Name

		if err := generateAndWrite(kotlinFilename("domain/"+domain.LowerName()+"/"+domain.Name+"Domain"), "domain_class", struct {
			Domain Domain
		}{
			Domain: domain,
		}); err != nil {
			log.Panicf("Could not write file: %s", err)
		}

		if err := generateAndWrite(kotlinFilename("domain/"+domain.LowerName()+"/Types"), "types", struct {
			Domain Domain
		}{
			Domain: domain,
		}); err != nil {
			log.Panicf("Could not write file: %s", err)
		}
	}
}
