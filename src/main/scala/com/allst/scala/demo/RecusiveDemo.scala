package com.allst.scala.demo

/**
  * 函数的递归调用
  * @author YiYa
  * @since 2019-09-28 下午 05:07
  */
object RecusiveDemo {
  def main(args: Array[String]): Unit = {
    test(4)
  }

  def test(n: Int) {
    if (n > 2) {
      test(n -1)
    }
    println("n = " + n)
  }
}
