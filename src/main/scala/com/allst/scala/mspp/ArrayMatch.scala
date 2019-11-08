package com.allst.scala.mspp

/**
  * 数组匹配
  * @author YiYa
  * @since 2019-11-08 下午 10:59
  */
object ArrayMatch {
  def main(args: Array[String]): Unit = {
    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0),
        Array(1, 1, 0), Array(1, 1, 0, 1))){
      val result = arr match {
        case Array(0) => "0"
        case Array(x, y) => x + " = " + y
        case Array(0, _*) => "以0开头..."
        case _ => "Nothings"
      }

      println("result = " + result)
    }
  }
}
