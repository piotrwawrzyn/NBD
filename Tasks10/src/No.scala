class No extends Maybe[Nothing] {
  def applyFunction[A,R](f: A => R) : No = {
    new No()
  }

  def getOrElse[A](value: A) = {
    value
  }

  def map[A, R](f: A => R) = new No()

  def flatMap[A, R](f: A => R) = new No()
}
