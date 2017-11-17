val foo = project
    .in(file("foobar"))
    .settings(
        yax(
            file("yax/foobar"), // Path to yax project
            "foo", // Name of block to display
            "otherBlock", "andAnother" // More block names
        ),
        target := baseDirectory.value / "target" / "foo"
    )

val bar = project
    .in(file("foobar"))
    .settings(
        yax(file("yax/foobar"), "bar"),
        target := baseDirectory.value / "target" / "bar"
    )
