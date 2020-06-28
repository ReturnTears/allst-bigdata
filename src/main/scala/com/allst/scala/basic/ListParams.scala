package com.allst.scala.basic

/**
  * 列表List
  *
  * @author YiYa
  * @since 2020/6/28-11:16
  */
object ListParams extends App {
  val one = List(1, 2, 3)
  val two = List(4, 5, 6)
  val ot = one ::: two
  println(ot)

  val at = 3 :: two
  println(at)

  val con = 1 :: 2 :: 3 :: Nil
  println(con)

  println("---------------------常用方法---------------------")

  val comm = List("Hello", "Hi", "Language", "Java", "Scala", "JavaScript", "BigData")
  println(comm)

  println(comm(2))

  println(comm.count(c => c.length == 5))

  println(comm.drop(2))

  println(comm.dropRight(2))

  // println(comm.exists(c => c == "Scala")) // 等价于下一行：
  println(comm.contains("Scala"))

  println(comm.filter(c => c.length > 4))

  println(comm.forall(c => c.endsWith("c")))

  comm.foreach(print)

  println(comm.head)

  println(comm.init)

  println(comm.isEmpty)

  println(comm.last)

  println(comm.length)

  println(comm.map(c => c + " ~ Come On"))

  println(comm.mkString(", "))

  println(comm.reverse)

  println(comm.sortWith((s, t) => s.charAt(0).toLower < t.charAt(0).toLower))

  println(comm.tail)
}