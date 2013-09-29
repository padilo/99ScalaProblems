package p07

object p07 {
  def main(args: Array[String]): Unit = {
    println(flatten2(List(List(1, 1), 2, List(3, List(5, 8)))))
  }

  def flatten(l: List[Any]): List[Any] = {
    def flattenTR(elem:Any, result:List[Any]): List[Any] = {
	    elem match {
	      case List() => result
	      case x::tail => flattenTR(x, result):::flattenTR(tail, result):::result
	      case x => x::result
	    }
    }
    flattenTR(l, List())
  }

  def flatten2(l: List[Any]): List[Any] = {
    l flatMap {
      case x:List[_] => flatten2(x)
      case e => List(e)
    }
  }
}