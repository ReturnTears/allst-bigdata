package com.allst.scala.collect

/**
  * 元组
  * @author YiYa
  * @since 2019-10-17 下午 10:13
  */
object TupleDemo {
  def main(args: Array[String]): Unit = {
    // 创建tuple, 类型是Tuple4
    // 为了高效的操作元组, 编译器根据元素的个数不同对应不同的元组类型, 分别对应Tuple1~Tuple22
    val tuplea = (1, 2, 3, "Hi", true)
    println(tuplea)

    println(tuplea._1)  // 访问第一个元素, 从1开始
    println(tuplea.productElement(0)) // 1:访问除第一个元素外剩下元素的第一个元素, 0第一个元素

    // 遍历元组
    for (item <- tuplea.productIterator) {
      println("item = " + item)
    }
  }
}
