class No extends Maybe[Nothing] {
  def applyFunction[A,R](f: A => R) : No = {
    new No()
  }

  def getOrElse[A](value: A) = {
    value
  }
}
