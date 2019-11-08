package com.allst.scala.mspp

/**
  * 类型匹配
  * @author YiYa
  * @since 2019-11-08 下午 10:30
  */
object TypeMatch {
  def main(args: Array[String]): Unit = {
    val a = 7
    val obj =
      if (a == 1) 1
      else if (a == 2) "2"
      else if (a == 3) BigInt(3)
      else if (a == 4) Map("aa" -> 1)
      else if (a == 5) Map(1 -> "bb")
      else if (a == 6) Array(1, 2, 3)
      else if (a == 7) Array("aa", 1)
      else if (a == 8) Array("aa")

    val result = obj match {
      case a: Int => a
      case b: Map[String, Int] => "map集合"
      case c: Map[Int, String] => "Map集合"
      case d: Array[String] => "字符串"
      case e: Array[Int] => "ZiFuChuan"
      case f: BigInt => Int.MaxValue
      case _ => "Nothing"
    }

    println(result)
  }
}
