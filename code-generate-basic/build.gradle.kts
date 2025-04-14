plugins {
    id("java")
}

group = "com.mi"
version = "1.0-SNAPSHOT"

repositories {
    maven(url = "https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.freemarker:freemarker:2.3.32")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("cn.hutool:hutool-all:5.8.26")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}