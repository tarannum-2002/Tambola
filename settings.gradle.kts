plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "Tambola"
include("src:test:kotlin")
findProject(":src:test:kotlin")?.name = "kotlin"
