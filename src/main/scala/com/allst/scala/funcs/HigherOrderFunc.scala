package com.allst.scala.funcs

/**
  * 高阶函数
  * @author YiYa
  * @since 2019-11-19 下午 09:09
  */
object HigherOrderFunc {
    def main(args: Array[String]): Unit = {
        val result = test(sumParam, 70.0)
        println(result)
    }

    def test(f: Double => Double, n: Double) = {
        f(n)
    }
    //
    def sumParam(d: Double): Double = {
        d * 2
    }
}
