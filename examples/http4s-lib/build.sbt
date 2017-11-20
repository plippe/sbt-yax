def http4sSettings(http4sVersion: String) = Seq(
    libraryDependencies ++= Seq(
        "org.http4s" %% "http4s-dsl" % http4sVersion
    )
)

val http4s016 = project
    .in(file("http4s"))
    .settings(
        yax(file("yax/http4s"), "0.16"),
        target := baseDirectory.value / "target" / "0.16",
        http4sSettings("0.16.5")
    )

val http4s17 = project
    .in(file("http4s"))
    .settings(
        yax(file("yax/http4s"), "0.17"),
        target := baseDirectory.value / "target" / "0.17",
        http4sSettings("0.17.5")
    )
