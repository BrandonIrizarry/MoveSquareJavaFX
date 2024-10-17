plugins {
    application
    id("org.javamodularity.moduleplugin") version "1.8.12"
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "xyz.brandonirizarry"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/BrandonIrizarry/MoveSquareBackend")
        credentials {
            username = System.getenv("GITHUB_USER")
            password = System.getenv("GITHUB_PAT")
        }
    }

    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("xyz.brandonirizarry:move-square-backend:1.0")
}

application {
    mainClass = "xyz.brandonirizarry.demogame.Main"
    mainModule = "xyz.brandonirizarry.demoGame"
}

tasks.test {
    useJUnitPlatform()
}

javafx {
    version = "21"
    modules("javafx.controls", "javafx.fxml", "javafx.media")
}
