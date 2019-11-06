package com.allst.scala.mspp

/**
  * 模式匹配
  * @author YiYa
  * @since 2019-11-06 下午 11:52
  */
object MatchDemo {
  def main(args: Array[String]): Unit = {
    method2()

  }

  def method1(): Unit = {
    val oper = '/'
    val n1 = 20
    val n2 = 10
    var res = 0
    oper match {
      case '+' => res = n1 + n2
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      case _ => println("match error")
    }
    println(res)
  }

  def method2(): Unit = {
    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        // 如果case后有条件守卫即if语句, 那么这时的_不是模式匹配的默认项, 表示忽略传入的ch
        case _ if ch.toString.equals("3") => digit = 3
        case _ if ch > 100 => println("it`s match")
        case _ => sign = 7
      }
      println(ch + " " + sign + " " + digit)
    }
  }
}
