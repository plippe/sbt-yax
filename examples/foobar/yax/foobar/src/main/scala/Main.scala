object Main extends App {

#+foo
  val helloWorld = "foo"
#-foo

#+bar
  val helloWorld = "bar"
#-bar

  println(helloWorld)
}
