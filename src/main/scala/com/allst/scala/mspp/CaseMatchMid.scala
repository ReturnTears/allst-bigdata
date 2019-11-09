package com.allst.scala.mspp

/**
  * 模式匹配中置表达式
  * @author YiYa
  * @since 2019-11-09 下午 11:30
  */
object CaseMatchMid {
  def main(args: Array[String]): Unit = {
    List(1,2,3,4,5,6,7) match {
        // 两个元素间的::叫中置表达式
      case x :: y :: z => println(x + y + z.length)
      case _ => println("Nothing")
    }
  }
}
