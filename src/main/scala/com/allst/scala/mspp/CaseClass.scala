package com.allst.scala.mspp

/**
  * 样例类
  * @author YiYa
  * @since 2019-11-09 下午 08:08
  */
object CaseClass {
  def main(args: Array[String]): Unit = {
    // 使用样例类进行模式匹配
    for (atm <- Array(Doller(1000.0), Currency(2000.0, "RMB"))) {
      val result = atm match {
        case Doller(n) => "$" + n
        case Currency(v, n) => v + " " + n
        case NoAmount => ""
      }
      println(atm + " : " + result)
    }
    println("CaseClass")
  }
}

abstract class Amount
// 以下三个为样例类
case class Doller(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object NoAmount extends Amount