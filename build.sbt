sbtPlugin := true

organization := "com.github.plippe"
name := "sbt-yax"

publishMavenStyle := false
bintrayRepository := "sbt-yax"
bintrayOmitLicense := true
bintrayOrganization in bintray := None

enablePlugins(GitVersioning)
