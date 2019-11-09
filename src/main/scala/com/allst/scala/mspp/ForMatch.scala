package com.allst.scala.mspp

/**
  * @author YiYa
  * @since 2019-11-09 下午 06:59
  */
object ForMatch {
  def main(args: Array[String]): Unit = {
    val map = Map("A" -> 1, "B" -> 2, "C" -> 3)
    for ((k, v) <- map) {
      println(k + " " + v)
    }
    // 只遍历v = 2的元素
    for ((k, 2) <- map) {
      println(k + " " + 0)
    }
    // 遍历符合If守卫语句的元素
    for ((k, v) <- map if v == 2) {
      println(k + " " + v)
    }
  }
}
