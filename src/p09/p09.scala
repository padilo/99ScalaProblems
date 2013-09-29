package p09

object p09 {
  def main(args: Array[String]): Unit = {
    println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  def pack[T](l: List[T]): List[List[T]] = {
    l.groupBy((x=>x)).values.toList
  }

}