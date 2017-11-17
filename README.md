# sbt-yax

> Yax has been extracted from the [doobie][1] project. [The code][2] has been written by Rob Norris, not me.
> I have only converted it to an sbt plugin.


Yax is a simple templating solution that runs before compilation to avoid repetition. It is particular useful to
generate multiple projects that are barely different; e.g. scala versions, library dependencies, hard coded constantes.


### Installing sbt-yax

To add sbt-yax to your build, two updates are required.

```sbt
// in project/plugins.sbt
resolvers += Resolver.url("plippe-sbt-yax", url("http://dl.bintray.com/plippe/sbt-yax"))(Resolver.ivyStylePatterns)
addSbtPlugin("com.github.plippe" % "sbt-yax" % "0.1.0")
```

```sbt
// in build.sbt
enablePlugins(Yax)
```


### Using sbt-yax

#### Defining your yax projects

Here are two identical projects. The only difference is that one outputs foo, while the other outputs bar. This problem
could have been solved in many simpler ways. For harder examples, look at the [other examples].

```sbt
// in build.sbt
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
```


#### Defining your yax blocks

The avoid repetition, those two projects will share the same code base, `yax/foobar`. The flags identify blocks of code
to include in the final project. A block opens with `#+[BLOCK_NAME]` and closes with `#-[BLOCK_NAME]`.

```scala
object Main extends App {

#+foo
  var helloWorld = "foo"
#-foo

#+bar
  val helloWorld = "bar"
#-bar

  println(helloWorld)
}
```

Running `sbt foo/run` will display `foo`, while `sbt bar/run` prints `bar`. Furthermore, the `foo` project doesn't have
any references to `bar`, and `bar` none to `foo`. This is particularly useful when the two projects depends on
different libraries, and the blocks contain the imports.


[1]: https://github.com/tpolecat/doobie
[2]: https://github.com/tpolecat/doobie/blob/c2bcbf52d324b79f2f07c4f9f353169141cb0f6b/project/yax.scala
[3]: https://github.com/plippe/sbt-yax/tree/master/examples
