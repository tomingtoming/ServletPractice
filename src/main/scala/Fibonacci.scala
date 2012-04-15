class Fibonacci extends SimpleNumberApiServlet {
  override def response(req:BigInt):Option[BigInt] = try {
    if(req.isValidInt) Option(fibonacci(req.toInt)) else None
  } catch {
    case _ => None
  }
  object fibonacci {
    private def fib(n:BigInt,m:BigInt):Stream[BigInt] = n #:: fib(m,n+m)
    private val stream = fib(0,1)
    def apply(n:Int) = stream(n)
  }
}

