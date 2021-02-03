class Container[A](private val value: A) {

  def getContent() : A = {
     value
  }

  def applyFunction[R](fun: A => R): R = {
    fun(getContent())
  }
}
