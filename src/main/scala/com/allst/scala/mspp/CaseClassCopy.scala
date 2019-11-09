package com.allst.scala.mspp

/**
  * 样例类带名参数
  * @author YiYa
  * @since 2019-11-09 下午 11:18
  */
object CaseClassCopy {
  def main(args: Array[String]): Unit = {
    val atm = new Currency2(3000.0, "RMB")
    // 类似Java中的clone
    val atm2 = atm.copy()
    println(atm2.value)
    val atm3 = atm.copy(value = 7000.89)
    println(atm3.value + " " + atm3.unit)
  }
}
abstract class Amount2
// 以下三个为样例类
case class Doller2(value: Double) extends Amount2
case class Currency2(value: Double, unit: String) extends Amount2
case object NoAmount2 extends Amount2