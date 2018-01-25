import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by extra
buildscript {
    var kotlinVersion: String by extra
    kotlinVersion = "1.2.21"
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}
plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}
apply {
    plugin("kotlin")
}

gradlePlugin {
    (plugins) {
        "myPlugin" {
            id = "dpdcy"
            implementationClass = "plugin.MyPlugin"
        }
    }
}

publishing {
    repositories {
        maven(url = "build/repository")
    }
}
dependencies {
    compile(kotlin("stdlib-jdk8", kotlinVersion))
}
repositories {
    jcenter()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}