class Yes[A](var value: A) extends Maybe[A]  {
  def applyFunction[R] (fun: A => R) = fun(value)
  def getOrElse(param: A) = value
}
