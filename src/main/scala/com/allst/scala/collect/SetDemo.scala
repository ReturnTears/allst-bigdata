package com.allst.scala.collect

import scala.collection.mutable

/**
  * @author YiYa
  * @since 2019-10-31 下午 10:44
  */
object SetDemo {
  def main(args: Array[String]): Unit = {
    val set = Set(1, 2, 3, 4) // 不可变
    println(set)

    val set2 = mutable.Set(1, 2, 3, 4, "5", "abc", "@") //可变
    println(set2)

    println(set.max)
    println(set.min)

    for (x <- set2) {
      println(x)
    }
  }
}
