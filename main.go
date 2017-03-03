package main

import (
	"encoding/json"
	"flag"
	"github.com/davecgh/go-spew/spew"
	"io/ioutil"
	"log"
	"os"
)

var protocolFile string

type Protocol struct {
	Version Version  `json:"version,omitempty"`
	Domains []Domain `json:"domains,omitempty"`
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

type Type struct {
	Id           string     `json:"id,omitempty"`
	Type         string     `json:"type,omitempty"`
	Enum         []string   `json:"enum,omitempty"`
	Description  string     `json:"description,omitempty"`
	Properties   []Property `json:"properties,omitempty"`
	Experimental bool       `json:"experimental,omitempty"`
	Items        *RefItem   `json:"items,omitempty"`
	MaxItems     uint       `json:"maxItems,omitempty"`
	MinItems     uint       `json:"minItems,omitempty"`
}

type Command struct {
	Name         string        `json:"name,omitempty"`
	Description  string        `json:"description,omitempty"`
	Returns      []ReturnValue `json:"returns,omitempty"`
	Parameters   []Parameter   `json:"parameters,omitempty"`
	Experimental bool          `json:"experimental,omitempty"`
	Redirect     string        `json:"redirect,omitempty"`
	Handlers     []string      `json:"handlers,omitempty"`
}

type ReturnValue struct {
	Name         string   `json:"name,omitempty"`
	Type         string   `json:"type,omitempty"`
	Reference    string   `json:"$ref,omitempty"`
	Description  string   `json:"description,omitempty"`
	Experimental bool     `json:"experimental,omitempty"`
	Items        *RefItem `json:"items,omitempty"`
	Optional     bool     `json:"optional,omitempty"`
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

type Property struct {
	Name         string   `json:"name,omitempty"`
	Type         string   `json:"type,omitempty"`
	Description  string   `json:"description,omitempty"`
	Optional     bool     `json:"optional,omitempty"`
	Reference    string   `json:"$ref,omitempty"`
	Items        *RefItem `json:"items,omitempty"`
	Experimental bool     `json:"experimental,omitempty"`
	Enum         []string `json:"enum,omitempty"`
	MinItems     uint     `json:"minItems,omitempty"`
	MaxItems     uint     `json:"maxItems,omitempty"`
}

type Event struct {
	Name         string      `json:"name,omitempty"`
	Description  string      `json:"description,omitempty"`
	Parameters   []Parameter `json:"parameters,omitempty"`
	Experimental bool        `json:"experimental,omitempty"`
}

func init() {
	flag.StringVar(&protocolFile, "protocol-file", "protocol.json", "")
}

func main() {
	flag.Parse()

	file, err := os.Open(protocolFile)
	if err != nil {
		log.Panicf("Could not open file: %s", file)
	}

	protocol := &Protocol{}

	if err := json.NewDecoder(file).Decode(protocol); err != nil {
		log.Panicf("Could not read json: %s", err)
	}

	spew.Dump(protocol)

	buff, err := json.MarshalIndent(protocol, "", "   ")
	if err == nil {
		log.Printf("Writing to file: %s", "protocol2.json")
		err := ioutil.WriteFile("protocol2.json", buff, 0644)
		log.Printf("Result: %v", err)

	} else {
		log.Panicf("Could not marshal file: %v", err)
	}
}
