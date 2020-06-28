package com.allst.scala.basic

/**
  * 元组
  *
  * @author YiYa
  * @since 2020/6/28-13:44
  */
object TupleParams extends App {
  val pair = (1, 2, "Hi", 3.45)
  println(pair)
  println(pair._3)
  println(pair.getClass)
}
