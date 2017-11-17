// build root project
lazy val root = Project("plugins", file(".")) dependsOn(yax)

// depends on the publishDoc project
lazy val yax = RootProject(file("../../.."))
