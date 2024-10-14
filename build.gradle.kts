plugins {
    application
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
