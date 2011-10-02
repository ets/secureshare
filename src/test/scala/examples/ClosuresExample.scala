object ClosuresExample extends Application {
  def makeIncrementer(inc: Int): (Int => Int) = {
          (x: Int) => x + inc
  }
  
  val a = makeIncrementer(10)
  val b = makeIncrementer(20)
  val c = makeIncrementer(20)
  
  println("Is b equal to c ? " + (b == c) )
  println(a(1))
  println(a(2))
  println(a(3))
  println(a(10))
  println(b(1))
  println(b(2))
  println(b(3))
}
