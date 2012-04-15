class Factorial extends SimpleNumberApiServlet {
  override def response(req:BigInt):Option[BigInt] = try {
    if(req.isValidInt) Option(factorial(req.toInt)) else None
  } catch {
    case _ => None
  }
  object factorial {
    private val stream = 0 #:: Stream.from(1).map(BigInt(_)).scanLeft(BigInt(1))(_*_).tail
    def apply(n:Int):BigInt = stream(n)
  }
}

