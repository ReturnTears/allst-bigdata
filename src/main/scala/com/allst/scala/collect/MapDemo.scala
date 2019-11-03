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

    // getOrElse
    println(map3.getOrElse("key", "default"))

    // map新增和修改
    map3("Name") = "YiYa"
    println(map3)

    // 添加单个元素
    map3 += ("age" -> 4)
    println(map3)

    // 删除单个元素
    map3 -= ("hello")
    println(map3)

    // Map的遍历 - 遍历key
    for (k <- map3.keys) println(k)
    // Map的遍历 - 遍历value
    for (v <- map3.values) println(v)
    // Map的遍历 - 遍历key -value
    for ((k, v) <- map3) println(k + " : " + v)
    // Map的遍历 - 遍历v, 这时候v是元组的方式
    for (v <- map3) println(v + ", key = " + v._1 + ", value = " + v._2)

    // 案例1
    val mapD = List("hi", "scala")
    def upper(s: String): String = {
      s.toUpperCase
    }
    val mapN = mapD.map(upper)
    println(mapN)

  }
}
