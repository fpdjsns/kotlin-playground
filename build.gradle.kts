plugins {
  kotlin("jvm") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))

  testImplementation("org.jetbrains.kotlin:kotlin-test:1.0.6")

  testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.3.2")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.5.2")
}

tasks {
  compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
  compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
}

tasks {
  test {
    useJUnitPlatform { excludeEngines("junit-vintage") }
  }
}