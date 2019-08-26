package com.allst.scala.demo

/**
  * 对象中的隐式转换类
  * @author JUNN
  * @since 2019-08-26 下午 10:39
  */
object StringUtils {
  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
  }
}
