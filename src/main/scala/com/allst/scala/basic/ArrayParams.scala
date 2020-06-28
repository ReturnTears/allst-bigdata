package com.allst.scala.basic

/**
  * 类型参数化数组
  * @author YiYa
  * @since 2020/6/28-10:31
  */
object ArrayParams extends App {
  val numNames = Array("Zero", "One", "Two")
  // val numNames = Array.apply("Zero", "One", "Two") //完整写法
  for (i <- numNames.indices)    // 其他替换方式： 0 until numNames.length 或者 0 to numNames.length - 1
    println(numNames(i))
}
