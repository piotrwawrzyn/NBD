object Main {
  def generator: Iterator[(Int, Int)] = for {
    i <- Iterator.from(1)
    j <- 1 until i+1 if i%j == 0
  } yield (a,b)


  def main(args: Array[String]) = {
   generator take(10) foreach println

    val buf = generator.buffered
    for (i <- 0 until 20) {
      println(buf.next())
    }
 }
}
