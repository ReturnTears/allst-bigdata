package com.allst.scala.guig.demo

/**
  * 数据类型转换
  * @author JUNN
  * @since 2019-07-27 上午 02:17
  */
object DataTypeTransform {
  def main(args: Array[String]): Unit = {
    var n1 = 10
    var n2 = 1.1
    var n3 = n1 + n2

    var n4:Byte = 10
    // 大精度赋值给小精度就会报错
    //var n5:Char = n4

    // 标识符(操作符可以作为标识符)
    val ++ = "Hello World"
    println(++)

    val `true` = "Hello Scala"
    println(`true`)

    // 算术运算符
    var r1: Double = 10.0 / 3
    var r2 = r1.formatted("%.2f")
    println(r2)

    // 赋值运算符
    var num = 2
    num <<= 2
    println("num = " + num)

    // 在Scala中支持代码块,返回值
    val res = {
      if (num > 1) "Yes" else "No"
    }
    println("res = " + res)

    // 两个变量a和b,要求将其进行交换,但是不能使用中间变量
    var a = 10
    var b = 20
    a = a + b
    b = a - b   // (a + b) - b
    a = a - b   // (a + b) - a

    // 使用位运算


    // 三目运算替换
    val num2 = if (num > a) "TRUE" else "FALSE"
    println("num2 = " + num2)
  }
}
