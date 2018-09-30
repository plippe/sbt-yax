sbtPlugin := true

organization := "com.github.plippe"
name := "sbt-yax"

publishMavenStyle := false
bintrayRepository := "sbt"
bintrayOrganization in bintray := None

enablePlugins(GitVersioning)
git.useGitDescribe := true

scalaVersion := "2.12.6"
crossSbtVersions := Vector("0.13.17", "1.2.3")
