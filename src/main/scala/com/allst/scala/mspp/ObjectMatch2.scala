package com.allst.scala.mspp

/**
  * 对象匹配2
  * @author YiYa
  * @since 2019-11-09 下午 06:32
  */
object ObjectMatch2 {
  def main(args: Array[String]): Unit = {
    val nameStr = "Alice, Bob, Thomas"
    nameStr match {
      case Names(x, y, z) => {
        println(s"$x $y $z")
      }
      case _ => println("Nothing")
    }
  }
}
object Names {
  // 当构造器时多个参数时就会调用该提取器
  def unapplySeq(str: String): Option[Seq[String]] = {
    if (str.contains(","))
      Some(str.split(","))
    else
      None
  }
}