package p07

object p07 {
  def main(args: Array[String]): Unit = {
    println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }

  def flatten(l: List[Any]): List[Any] = {
    def flattenTR(l:Any, result:List[Any]): List[Any] = {
	    l match {
	      case List() => result
	      case x::tail => flattenTR(x, result):::flattenTR(tail, result):::result
	      case x => x::result
	    }
    }
    flattenTR(l, List())
  }
}