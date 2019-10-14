package com.allst.scala.impli

/**
  * implicit隐式转换:
  * 1), 隐式转换函数的函数名可以是任意的, 隐式转换与函数名称无关, 只与函数签名有关(函数参数类型和返回值类型)
  * 2), 隐式函数可以有多个(即: 隐式函数列表), 但是需要保证在当前环境下, 只有一个隐式函数能被识别
  *
  * @author YiYa
  * @since 2019-10-14 下午 08:53
  */
object ImplicitDemo {
  def main(args: Array[String]): Unit = {
    // 编写一个隐式转换函数Double => Int

    // 底层生成了f1$1, 隐式函数要在作用域中才能生效
    implicit def f1(d: Double): Int = {
      d.toInt
    }

    implicit def f2(f: Float): Int = {
      f.toInt
    }

    val num: Int = 3.5  // 底层编译f1$1(3.5)
    println("num = " + num)

    val num2: Int = 6.7f
  }
}


