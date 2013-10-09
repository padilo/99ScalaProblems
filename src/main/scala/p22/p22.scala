package p22

import scala.annotation.tailrec

/*
 * Create a list containing all integers within a given range.inclusi
 * Example:
 * scala> range(4, 9)
 * res0: List[Int] = List(4, 5, 6, 7, 8, 9)
 */
object p22 {
  def main(args: Array[String]) = {
    def test(name: String, f: (Int, Int) => List[Int]) = {

      println(name)
      println(f(4, 9))
      println
    }

    test("range", range)
    test("range2", range2)
    test("range3", range3)
  }

  def range(i: Int, j: Int): List[Int] = {
    (i to j).toList
  }

  def range2(i: Int, j: Int): List[Int] = {
    if (i > j) List()
    else i :: range2(i + 1, j)
  }

  // Easy
  def range3(i: Int, j: Int): List[Int] = {
    @tailrec
    def range3TR(i: Int, j: Int, result: List[Int]): List[Int] = {
      if (i > j) result.reverse
      else range3TR(i + 1, j, i :: result)
    }
    
    range3TR(i, j, List())
  }
}