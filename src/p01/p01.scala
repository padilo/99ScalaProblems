package p01

import java.util.NoSuchElementException

object p01 {
  def main(args: Array[String]):Unit = {
	 println(last(List(1, 1, 2, 3, 5, 8)))
	 println(last(List()))
  }
  
  def last(l:List[Int]):Int = l match {
    case head::List() => head
    case head::tail => last(tail)
    case _ => throw new NoSuchElementException
  }
}