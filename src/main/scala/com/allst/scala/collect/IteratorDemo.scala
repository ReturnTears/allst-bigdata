package com.allst.scala.collect

/**
  * 迭代器Iterator
  * @author YiYa
  * @since 2019-11-03 下午 04:29
  */
object IteratorDemo {
  def main(args: Array[String]): Unit = {
    val iter = List(1, 2, 3, 4, 5).iterator

    // 遍历元素方式1
    /*while (iter.hasNext) {
      println(iter.next())
    }*/

    // 遍历元素方式2
    for (enum <- iter) {
      println(enum)
    }
  }
}
