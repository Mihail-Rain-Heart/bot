plugins {
    application
    kotlin("jvm") version "1.9.10"
}

application {
    mainClass.set("AppKt")
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.1.0")
}