package com.allst.scala.collect

import scala.collection.mutable

/**
  * 无序可变的Map是默认的
  *
  * 有序不可变的Map需要引包
  *
  * @author YiYa
  * @since 2019-10-27 上午 11:23
  */
object MapDemo {
  def main(args: Array[String]): Unit = {
    // 不可变
    val map0 = Map("name" -> "Scala", "age" -> 11)
    println(map0)

    // 可变
    val map1 = mutable.Map("hello" -> "world", "Hi" -> "Scala", "Nums" -> 10)
    println(map1)

    // 创建空的映射
    val map2 = new mutable.HashMap[String, Int]
    println("map2 = " + map2)

    // 对偶元组: 即创建包含键值对的二元组, 和map1方式等价, 只是形式上不同而已, 对偶元组就是只含两个数据的元组
    val map3 = mutable.Map(("hello", "world"), ("Hi", "Scala"), ("Nums", 10))
    println(map3)
  }
}
