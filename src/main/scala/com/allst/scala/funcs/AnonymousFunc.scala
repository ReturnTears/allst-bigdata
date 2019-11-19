package com.allst.scala.funcs

/**
  * 匿名函数
  * @author YiYa
  * @since 2019-11-19 下午 09:02
  */
object AnonymousFunc {
    def main(args: Array[String]): Unit = {
        val triple = (x: Double) => x * 3
        println("triple : " + triple(7))
    }
}
