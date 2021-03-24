val kotlinVersion = "1.4.31"

plugins {
    id("maven")
    id("maven-publish")
    id("signing")
    id("groovy")
    id("pl.allegro.tech.build.axion-release") version "1.12.1"
    id("com.github.ben-manes.versions") version "0.38.0"
    id("org.jmailen.kotlinter") version "3.3.0"
    id("io.github.gradle-nexus.publish-plugin") version "1.0.0"
    id("org.jetbrains.dokka") version "1.4.30"
    id("com.adarshr.test-logger") version "2.1.1"
    kotlin("jvm") version "1.4.31"
    kotlin("kapt") version "1.4.31"
    kotlin("plugin.serialization") version "1.4.31"
}

java {
    targetCompatibility = JavaVersion.VERSION_11
    sourceCompatibility = JavaVersion.VERSION_11
}

ext {
    set("sonatypeUsername", System.getenv("SONATYPE_USERNAME") ?: "")
    set("sonatypePassword", System.getenv("SONATYPE_PASSWORD") ?: "")
    set("githubToken", System.getenv("GITHUB_TOKEN") ?: "")
    set("signingKeyId", System.getenv("SIGNING_KEY_ID") ?: "")
    set("signingKey", System.getenv("SIGNING_KEY") ?: "")
    set("signingKeyPassword", System.getenv("SIGNING_KEY_PASSWORD") ?: "")
    set("sonatypeStagingProfileId", "5028463f095590")
    set("sonatypePackageGroup", "pl.wendigo")
}

scmVersion {
    tag.prefix = "chrome-reactive-kotlin"
    repository.customUsername = project.ext["githubToken"] as String
    repository.pushTagsOnly = true
    useHighestVersion = true

    val pattern = KotlinClosure2({ currentVersion: String, c: pl.allegro.tech.build.axion.release.domain.hooks.HookContext ->
        "\\Q${currentVersion}\\E"
    })

    val replacement = KotlinClosure2({ newVersion: String, c: pl.allegro.tech.build.axion.release.domain.hooks.HookContext ->
        newVersion
    })

    hooks.pre("fileUpdate", mapOf("file" to "README.md", "pattern" to pattern, "replacement" to replacement))

    hooks.pre("commit", KotlinClosure2({ version: String, s: pl.allegro.tech.build.axion.release.domain.scm.ScmPosition ->
        "Release version $version from branch ${s.branch}"
    }))

    hooks.post("push")
}

group = "pl.wendigo"
version = scmVersion.version

extra["isReleaseVersion"] = !version.toString().endsWith("SNAPSHOT")

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://jitpack.io")
    }
}

testlogger {
    theme = com.adarshr.gradle.testlogger.theme.ThemeType.MOCHA
    showExceptions = true
    showStackTraces = true
    showFullStackTraces = false
    showCauses = true
    slowThreshold = 30000
    showSummary = true
    showSimpleNames = false
    showPassed = true
    showSkipped = true
    showFailed = true
    showStandardStreams = true
    showPassedStandardStreams = true
    showSkippedStandardStreams = true
    showFailedStandardStreams = true
    logLevel = LogLevel.LIFECYCLE
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("io.reactivex.rxjava3:rxjava:3.0.11")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
    implementation("org.testcontainers:testcontainers:1.15.2")
    implementation("org.slf4j:slf4j-api:1.7.30")

    testImplementation("org.spockframework:spock-core:1.3-groovy-2.5")
    testImplementation("ch.qos.logback:logback-classic:1.2.3")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.languageVersion = "1.4"
    kotlinOptions.javaParameters = true
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.verbose = false
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
    dokkaSourceSets {
        named("main") {
            moduleName.set("Chrome Reactive Kotlin")
            jdkVersion.set(11)
            reportUndocumented.set(true)
            skipDeprecated.set(false)
            skipEmptyPackages.set(true)
            samples.from("src/samples/kotlin")
            includes.from("package.md", "domains.md")

            sourceLink {
                localDirectory.set(file("./src/main/kotlin"))
                remoteUrl.set(uri("https://github.com/wendigo/chrome-reactive-kotlin/tree/master/src/main/kotlin").toURL())
                remoteLineSuffix.set("#L")
            }
        }
    }
}

tasks.named<Jar>("javadocJar") {
    archiveClassifier.set("javadoc")
    dependsOn("dokkaHtml")
    from("$buildDir/dokka")
}

sourceSets {
    val samples by creating {
        compileClasspath += sourceSets["main"].output
        compileClasspath += sourceSets["main"].compileClasspath

        runtimeClasspath += sourceSets["main"].output
        runtimeClasspath += sourceSets["main"].runtimeClasspath
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set("chrome-reactive-kotlin")
                description.set("Chrome Reactive - low level, remote chrome debugger protocol client (DevTools)")
                url.set("https://github.com/wendigo/chrome-reactive-kotlin")
                inceptionYear.set("2017")

                scm {
                    connection.set("scm:git:https://github.com/wendigo/chrome-reactive-kotlin.git")
                    url.set("https://github.com/wendigo/chrome-reactive-kotlin")
                    developerConnection.set("scm:git:https://github.com/wendigo/chrome-reactive-kotlin.git")
                }

                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        name.set("Mateusz \"Serafin\" Gajewski")
                        email.set("contact@wendigo.pl")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            url = uri("https://oss.sonatype.org/service/local/")

            credentials {
                username = project.ext["sonatypeUsername"] as String
                password = project.ext["sonatypePassword"] as String
            }
        }

        maven {
            url = uri("https://maven.pkg.github.com/wendigo/chrome-reactive-kotlin")
            name = "Github"

            credentials {
                username = "wendigo"
                password = project.ext["githubToken"] as String
            }
        }
    }
}

signing {
    setRequired({
        (project.extra["isReleaseVersion"] as Boolean) && project.ext["signingKeyId"] != null
    })

    useInMemoryPgpKeys(
        project.ext["signingKeyId"] as String,
        project.ext["signingKey"] as String,
        project.ext["signingKeyPassword"] as String
    )
    sign(publishing.publications.getByName("mavenJava"))
}

tasks.named<Wrapper>("wrapper") {
    version = "6.8.3"
    distributionType = Wrapper.DistributionType.ALL
}

kotlinter {
    ignoreFailures = false
    indentSize = 4
    reporters = arrayOf("checkstyle", "plain")
    experimentalRules = true
    disabledRules = arrayOf()
}

nexusPublishing {
    packageGroup.set(project.ext["sonatypePackageGroup"] as String)
    repositories {
        sonatype {
            username.set(project.ext["sonatypeUsername"] as String)
            password.set(project.ext["sonatypePassword"] as String)
            stagingProfileId.set(project.ext["sonatypeStagingProfileId"] as String)
        }
    }
}
