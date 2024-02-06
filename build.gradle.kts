plugins {
    id("java")
    id("io.freefair.lombok") version "8.4"
}

allprojects {
    group = "com.harbour"
    version = "0.0.1"
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}