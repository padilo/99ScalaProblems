package p18

/*
 * Extract a slice from a list.
 * Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
 * Example:
 * 
 * scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: List[Symbol] = List('d, 'e, 'f, 'g) 
 */
object p18 {
  def main(args: Array[String]) = {
    println(slice4(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  
  // Recursive
  def slice[T](i: Int, k: Int, l: List[T]): List[T] = {
    (i,k) match {
      case (0, 0) => List()
      case (0, k) => l.head::slice(i, k-1, l.tail)
      case (i, k) => slice(i-1, k-1, l.tail)
    }
  }

  // Tail recursive
  def slice2[T](i: Int, k: Int, l: List[T]): List[T] = {
    def sliceTR[T](i: Int, k: Int, l: List[T], result:List[T]): List[T] = {
	    (i,k) match {
	      case (0, 0) => result
	      case (0, k) => sliceTR(i, k-1, l.tail, l.head::result)
	      case (i, k) => sliceTR(i-1, k-1, l.tail, result)
	    }
    }
    
    sliceTR(i, k, l, List()).reverse
  }

  // Easy solution
  def slice3[T](i: Int, k: Int, l: List[T]): List[T] = {
    l.drop(i).take(k-i)
  }

  // Funny very inefficient solution, inspired by the one provided by Phil for p16
  def slice4[T](i: Int, k: Int, l: List[T]): List[T] = {
    l.zipWithIndex filter { v => v._2>=i && v._2< k } map (v=>v._1)
    
  }

}