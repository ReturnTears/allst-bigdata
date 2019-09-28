package com.allst.scala.demo

/**
  * 算法
  * @author YiYa
  * @since 2019-09-28 下午 06:15
  */
object Algorithm {
  def main(args: Array[String]): Unit = {
    val a = Funcs2(1)
    println(a)
  }

  /**
    * 递归实现斐波拉基数列
    * @param n
    *           常量
    */
  def Fibonacci(n: Int) : Int = {
    if (n < 3) {
      1
    } else {
      Fibonacci(n - 2) + Fibonacci(n - 1)
    }
  }

  /**
    * 套用公式
    * @param n
    * @return
    */
  def Funcs(n: Int): Int = {
    if (n == 1) {
      3
    } else {
      2 * Funcs(n -1) + 1
    }
  }

  /**
    * 猴子吃桃问题
    * @param n
    * @return
    */
  def Funcs2(n: Int): Int = {
    if (n == 10) {
      1
    } else {
      (Funcs2(n + 1) + 1) * 2
    }

  }
}
