import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

trait SimpleNumberApiServlet extends HttpServlet {
  def response(req:BigInt):Option[BigInt];
  override def doGet(req:HttpServletRequest, res:HttpServletResponse) {
    println(req.getParameter("n"))
    res.setContentType("text/plain")
    res.setCharacterEncoding("UTF-8")
    val writer = res.getWriter()
    try {
      response(req.getParameter("n").toInt) match {
        case Some(n) => writer.write(n.toString)
        case None => "Calculation failed:" + req.getParameter("n")
      }
    } catch {
      case e:NumberFormatException =>
        writer.write("Illigal number format:" + req.getParameter("n"))
      case e =>
        writer.write("Error:" + req.getParameter("n"))
        println("Error:" + e)
    }
  }
}

