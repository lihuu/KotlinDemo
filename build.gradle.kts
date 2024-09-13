println("This is executed in the configuration phase")

tasks.register("configured") {
    println("This is also executed during the configuration phase, because :configured is used in the build.")
}

tasks.register("test1") {
    doLast {
        println("This is executed during the execution phase")
    }
}

tasks.register("testBoth") {
    doFirst {
        println("This is executed first during the execution phase")
    }
    doLast {
        println("This is executed last during the execution phase")
    }
    println("This is executed during the configuration phase as well, because :testBoth is used in the build.")
}


plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation(kotlin("reflect"))

    testImplementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}