package p03

import java.util.NoSuchElementException

object p03 {
	def main(args: Array[String]):Unit = {
		println(nth(23, List(1, 1, 2, 3, 5, 8)))
		println(nthMatch(23, List(1, 1, 2, 3, 5, 8)))
	}
	
	def nth(i:Int, l:List[_]) = {
		l(i)
	}

	def nthMatch(i:Int, l:List[_]):Any = {
		l match {
		  case head::_ if(i==0) => head
		  case _::tail => nthMatch(i-1, tail)
		  case _ => throw new NoSuchElementException
		}
	}

}