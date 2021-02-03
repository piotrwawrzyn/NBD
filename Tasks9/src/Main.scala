object Main {
  def convertToUpperCase(str: String): String = {
    str.toUpperCase()
  }

  def main(args: Array[String]) = {
    val con = new Container[String]("base")
    println(con.getContent())
    println(con.applyFunction[String](convertToUpperCase))

    val yes = new Yes[String]("somevalue")
    val no = new No

    println(yes.isInstanceOf[Maybe[_]])
    println(no.isInstanceOf[Maybe[_]])

    println(yes.getOrElse("dsadas"))
    println(no.getOrElse("das"))
  }
}
