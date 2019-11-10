package com.allst.scala.mspp

/**
  * 匹配嵌套结构案例
  * @author YiYa
  * @since 2019-11-10 上午 11:48
  */
object salesDemo {
  def main(args: Array[String]): Unit = {
    // 打折案例
    val sale = Bundle("书籍", 10, Book("漫画", 40), Bundle("文学作品", 20, Book("<三国>", 80), Book("<西游>", 30)))

    val result = sale match {
      // 知识点1:使用case语句匹配得到"漫画"
      case Bundle(_, _, Book(x, _), _*) => x
      case _ => "Nothing"
    }
    println(result)

    val result2 = sale match {
        // 知识点2: 如果我们进行匹配时, 不想接受某些值, 则可以使用_忽略, _*忽略所有
      case Bundle(_, _, b1 @ Book(_, _), b2 @ _*) => (b1, b2)
      case _ => "Nothing"
    }
    println(result2)


    val result3 = sale match {
        // 知识点3: 不使用_*绑定剩余Item到b2
      case Bundle(_, _, b1 @ Book(_, _), b2) => (b1, b2)
      case _ => "Nothing"
    }
    println(result3)

  }
}
// 设计样例类
abstract class Item // 项

case class Book(description: String, price: Double) extends Item
//Bundle 捆 ， discount: Double 折扣 ， item: Item* (*表示多个)
case class Bundle(description: String, discount: Double, item: Item*) extends Item
