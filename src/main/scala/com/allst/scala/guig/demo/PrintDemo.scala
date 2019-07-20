package com.allst.scala.guig.demo

/**
  * print案例
  * @Auther JUNN
  * @Date 2019-07-20 上午 09:36
  */
object PrintDemo {
  def main(args: Array[String]): Unit = {
    val str1: String = "Hello"
    val str2: String = " Scala ~~"
    println(str1 + str2)

    var name: String = "JUNN"
    var age: Int = 12
    var sal: Float = 10.12f
    var hgt: Double = 180.17
    // 格式化输出
    printf("名字=%s 年龄是%d 薪水%.2f 身高%f", name, age, sal, hgt)

    // Scala支持使用$输出内容, 编译器会去解析$对应变量
    println(s"\n person info : \n name:$name \t age:$age \n sal:$sal \t height:$hgt")
    println(s"\n person info : \n name:$name \t age:${age + 10} \t sal:${sal * 1000} \t height:$hgt")
  }
}
