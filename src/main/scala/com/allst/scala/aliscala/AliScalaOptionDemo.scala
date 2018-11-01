package com.allst.scala.aliscala

/**
  * @author June 
  *         2018-07-11
  * @version 1.0
  */
object AliScalaOptionDemo extends App {
  val m=Map("hive"->2,"spark"->3,"Spark MLlib"->4)
  def mapPattern(t: String) = m.get(t) match {
    case Some(x) => println(x); x
    case None => println("none"); -1
  }
  println(mapPattern("Hive"))
}
