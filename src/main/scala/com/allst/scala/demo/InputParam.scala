package com.allst.scala.demo

import scala.io.StdIn

/**
  * 接收键盘输入
  *
  * @author JUNN
  * @since 2019-09-10 下午 11:29
  */
object InputParam {
  def main(args: Array[String]): Unit = {
    /*println("请输入姓名:")
    val name = StdIn.readLine()
    println("请输入年龄:")
    val age = StdIn.readInt()
    println("请输入薪水:")
    val sal = StdIn.readDouble()
    printf("用户的信息为 name=%s age=%d sal=%.2f", name, age, sal)
*/
    val a = 22
    val res = if (a > 18) {
      println("Hello World")
      a + 100
      "True"
    } else {
      a
    }
    println(res)

  }

  /**
    * Scala中任意表达式都有返回值的, 也就意味着if else表达式其实是由返回结果的, 具体返回结果的值取决于满足条件的代码体的最后一行内容
    */

}
