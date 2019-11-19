package com.allst.scala.funcs

/**
  * 高阶函数2
  * @author YiYa
  * @since 2019-11-19 下午 09:18
  */
object HigherOrderFunc2 {
    def main(args: Array[String]): Unit = {
        // 分步执行:f1 就是(y: Int) => 3 - y
        val f1 = minusXy(3)
        println(f1(1))

        // 一步到位
        println(minusXy(4)(9))
    }

    def minusXy(x: Int) = {
        (y: Int) => x - y  // 匿名函数
    }
}
