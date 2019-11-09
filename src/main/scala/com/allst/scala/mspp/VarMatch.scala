package com.allst.scala.mspp

/**
  * 变量匹配
  * @author YiYa
  * @since 2019-11-09 下午 06:48
  */
object VarMatch {
  def main(args: Array[String]): Unit = {
    val (x, y, z) = (1, 9, "Hi")
    println(x)

    val (q, r) = BigInt(10) /% 3
    println(q, r)

    val arr = Array(1, 3, 5, 7)
    val Array(a, b, _*) = arr
    println(a, b)
  }
}
