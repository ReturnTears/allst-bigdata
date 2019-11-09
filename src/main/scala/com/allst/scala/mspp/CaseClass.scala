package com.allst.scala.mspp

/**
  * 样例类
  * @author YiYa
  * @since 2019-11-09 下午 08:08
  */
object CaseClass {
  def main(args: Array[String]): Unit = {
    println("CaseClass")
  }
}

abstract class Amount
// 以下三个为样例类
case class Doller(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object NoAmount extends Amount