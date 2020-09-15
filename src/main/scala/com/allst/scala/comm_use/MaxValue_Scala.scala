package com.allst.scala.comm_use

/**
  * Scala在序列中获取最大值
  * @author JUNN
  * @since 2019-07-13 下午 12:49
  */
object MaxValue_Scala {
  def main(args: Array[String]): Unit = {
    new MaxValue().maxVal()
  }
}
// 计算最大值类
class MaxValue {
  def maxVal(): Unit = {
    val numbers = Seq(11, 2, 5, 1, 6, 3, 9, 17, 22)
    println(numbers.max)
    println(numbers.min)
  }

  // 增加操作数据的复杂度
  case class Book(title: String, pages: Int)

  val books = Seq(
    Book("Future of Scala developers", 85),
    Book("Parallel algorithms", 240),
    Book("Object Oriented Programming", 130),
    Book("Mobile Development", 495)
  )
  val max = books.maxBy(book => book.pages)
  println("Max Value :" + max)
  val min = books.minBy(book => book.pages)
  println("Min Value" + min)
}
