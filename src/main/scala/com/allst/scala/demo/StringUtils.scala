package com.allst.scala.demo

/**
  * 对象中的隐式转换类
  * @author JUNN
  * @since 2019-08-26 下午 10:39
  */
object StringUtils {

  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
    def decrement = s.map(c => (c - 1).toChar)
    // 返回到String类型是显式声明的
    def hideAll: String = s.replaceAll(".", "*")
    def plusOne = s.toInt + 1
    def asBoolean = s match {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }
  }
}
