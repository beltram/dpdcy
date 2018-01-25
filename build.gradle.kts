allprojects {
    group = "io.beltram"
    version = "0.0.1-SNAPSHOT"
}

tasks {
    val plugin by creating(GradleBuild::class) {
        dir = file("plugin")
        tasks = listOf("publish")
    }
    val consumer by creating(GradleBuild::class) {
        dir = file("consumer")
        tasks = listOf("myCopyTask")
    }
    consumer.dependsOn(plugin)
}