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
    implementation("info.picocli:picocli:4.7.6")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.jar{
    manifest {
        attributes["Main-Class"] = "com/mi/Main" // 替换为您的包名和主类名
    }

    // 如果需要将所有依赖项打包到 JAR 中，可以使用以下配置
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}