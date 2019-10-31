package com.allst.scala.collect

/**
  * 高阶函数
  * @author YiYa
  * @since 2019-10-31 下午 11:34
  */
object HighOrderFunc {
  def main(args: Array[String]): Unit = {
    val res = test(sum1, 7.0)
    println(res)

    // 在Scala中, 可用把一个函数直接赋值给一个变量, 这时相当于将函数的结果赋值给了变量
    // 但是如果想要函数不执行, 那么添加下划线_ 即可
    val myp = myPrint _ // 不执行
    myp() // 执行

  }

  def test(f: Double => Double, n1: Double): Double ={
    f(n1)
  }

  def sum1(d: Double): Double = {
    d * 2
  }

  def myPrint(): Unit = {
    println("Hello Scala")
  }
}
