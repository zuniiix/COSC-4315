plugins {
  kotlin("jvm") version "1.9.0"
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))  
}

tasks.test {
  useJUnitPlatform()
}

defaultTasks("clean", "test")


