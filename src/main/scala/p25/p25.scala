package p25

import scala.collection.mutable.ArraySeq

/*
 * Generate a random permutation of the elements of a list.
 * Hint: Use the solution of problem P23.
 * Example:
 * 
 * scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
 * res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 */
object p25 {
  def main(args: Array[String]) = {
	  println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
  }
  
  // Using P23
  def randomPermute[T](l:List[T]):List[T] = {
    p23.p23.randomSelect(l.length, l)
  }
  
}