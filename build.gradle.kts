plugins {
    application
    id("org.javamodularity.moduleplugin") version "1.8.12"
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "xyz.brandonirizarry"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(files("libs/MoveSquare.jar"))
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
