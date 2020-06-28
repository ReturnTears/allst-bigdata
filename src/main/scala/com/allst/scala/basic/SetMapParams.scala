package com.allst.scala.basic

import scala.collection.immutable
import scala.collection.mutable
/**
  * 集Set和映射Map
  * @author YiYa
  * @since 2020/6/28-14:06
  */
object SetMapParams extends App {
  // 不可变集
  var jetSet = Set("Java", "Scala", "JavaScript") // 可变使用+=需要对jetSet重新赋值，因此定义为变量（var）
  jetSet += "Haskell"
  println(jetSet)

  // 可变集
  val movSet = mutable.Set("Hitch", "Pole") // 因为movSet集是可变的，所以不需要对movSet重新赋值，所以定义为值（val）
  movSet += "Shell"
  movSet.+=("Bat")
  println(movSet)

  // 不可变的HashSet
  val hashSet = immutable.HashSet("Tomcat", "Negix")
  println(hashSet + "Yeild")

  val treasureMap = mutable.Map[Int, String]()
  treasureMap += (1 -> "Hello")
  treasureMap += (2 -> "Hei")
  println(treasureMap)
  println(treasureMap(2))

  val romanNumberal = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
  )
  println(romanNumberal(4))
}
