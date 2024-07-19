plugins {
	id("java")
    id("application")
}

group = "ru.daedal"
version = "0.0"

repositories {
    mavenCentral()
}

application {
	mainClass = "ru.daedal.Main"
}

dependencies {
	compileOnly("org.projectlombok:lombok:1.18.34")
	annotationProcessor("org.projectlombok:lombok:1.18.34")

	testCompileOnly("org.projectlombok:lombok:1.18.34")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
}