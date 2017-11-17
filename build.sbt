sbtPlugin := true

organization := "com.github.plippe"
name := "sbt-yax"

publishMavenStyle := false
bintrayRepository := "sbt-yax"
bintrayOrganization in bintray := None

enablePlugins(GitVersioning)

scalaVersion := "2.12.4"
crossSbtVersions := Vector("0.13.16", "1.0.3")
