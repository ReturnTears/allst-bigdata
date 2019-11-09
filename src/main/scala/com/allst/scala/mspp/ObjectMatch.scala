package com.allst.scala.mspp

/**
  * 对象匹配
  * @author YiYa
  * @since 2019-11-09 下午 06:07
  */
object ObjectMatch {
  def main(args: Array[String]): Unit = {
    val num: Double = 36.0
    num match {
        // 当匹配到case Square(n)时, 会自动去调用unhappy()方法, 并将num的值赋给arg,
        // 如果匹配成功返回Some(), 匹配失败返回None
      case Square(n) => println(n)
      case _ => println("Nothing")
    }
  }
}

object Square {
  /**
    * unapply方法是对象提取器
    * @param arg  Double参数
    * @return     将运算的结果放入Some集合并返回,
    */
  def unapply(arg: Double): Option[Double] = Some(math.sqrt(arg) + 1) // None

  def apply(arg: Double): Double = arg * arg
}