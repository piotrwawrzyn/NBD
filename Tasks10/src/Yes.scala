class Yes[A](var value: A) extends Maybe[A]  {
  def applyFunction[R] (fun: A => R) = fun(value)
  def getOrElse(param: A) = value
  def flatMap[R](f: A => Maybe[R]) = f(value)
  def map[R](f: A => Maybe[R]) = new Yes(f(value))
}
