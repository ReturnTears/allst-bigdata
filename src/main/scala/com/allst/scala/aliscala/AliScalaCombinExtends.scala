package com.allst.scala.aliscala

/**
  * @author June on 2018-06-14
  *         组合与继承的使用
  */
object AliScalaCombinExtends {

}

// 组合
class Head
class Body
class Hand

// PersonBoy类
abstract class PersonBoy(var name: String, var age: Int) {
  // 各类的实例作为该类对象的一部分，通过各类的实例方法实现代码重用
  val head: Head = null
  val body: Body = null
  val hand: Hand = null
}