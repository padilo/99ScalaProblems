package p23

import scala.util.Random
import scala.annotation.tailrec

/*
 * Extract a given number of randomly selected elements from a list.
 * Example:
 * scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
 * res0: List[Symbol] = List('e, 'd, 'a)
 */
object p23 {
  def main(args: Array[String]) {
    println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomSelect2(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
  }

  def randomSelect(n: Int, l: List[Symbol]): List[Symbol] = {
    if (n <= 0 || l.isEmpty) {
      List()
    } else {
      val randN = Random.nextInt(l.length)
      val (resultList, elem) = p20.p20.removeAt(randN, l)
      elem :: randomSelect(n - 1, resultList)
    }
  }

  def randomSelect2(n: Int, l: List[Symbol]): List[Symbol] = {
    @tailrec
    def randomSelectTR(n: Int, l: List[Symbol], result: List[Symbol]): List[Symbol] = {
      if (n <= 0 || l.isEmpty) {
        result
      } else {
        val randN = Random.nextInt(l.length)
        val (resultList, elem) = p20.p20.removeAt(randN, l)
        randomSelectTR(n - 1, resultList, elem::result)
      }
    }
    randomSelectTR(n, l, List())
  }

}