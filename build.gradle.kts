import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val junitVersion="5.10.0"
val http4kVersion="5.10.3.0"
val kotlinVersion="1.9.20"

plugins {
    kotlin("jvm") version "1.9.20"
    application
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.http4k:http4k-core:$http4kVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    testImplementation("org.http4k:http4k-testing-approval:$http4kVersion")
    testImplementation("org.http4k:http4k-testing-hamkrest:$http4kVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

application {
    mainClass.set("com.example.HelloWorldKt")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs += "-Xjvm-default=all"
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    useJUnitPlatform()
}