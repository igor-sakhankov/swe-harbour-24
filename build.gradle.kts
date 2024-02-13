plugins {
    id("org.openapi.generator") version "7.2.0"
    java
}

allprojects {
    group = "com.harbour"
    version = "0.0.1"
}

repositories {
    mavenCentral()
}
openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$projectDir/specs/petstore-v3.0.yaml")
    outputDir.set("$projectDir/generated")
    generateModelDocumentation.set(false)
    generateApiTests.set(false)
    generateModelTests.set(false)
    generateApiDocumentation.set(false)
}
