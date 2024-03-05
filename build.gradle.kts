plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.github.weave-mc.weave-gradle") version "fac948d"
}

val projectVersion: String by project
val projectGroup:   String by project

group = projectGroup
version = projectVersion

minecraft.version("1.8.9")

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.weave-mc:weave-loader:v0.2.6")
    implementation("net.java.jinput:jinput:2.0.10")

    configurations.all {
        resolutionStrategy {
            force("net.java.jinput:jinput:2.0.10")
        }
    }
}

tasks.getByName("build") {
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar {
    relocate("net.java.games.input", "me.nyaaa.jinput")
}

kotlin {
    jvmToolchain(17)
}