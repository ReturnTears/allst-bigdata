package com.allst.scala

/**
  * scala字段的覆写
  * @author YiYa
  * @since 2019-10-08 上午 12:59
  */
object ScalaFieldOverride {
  def main(args: Array[String]): Unit = {
    val obj1: ScalaFieldOverrideA = new ScalaFieldOverrideB
    val obj2: ScalaFieldOverrideB = new ScalaFieldOverrideB

    println("obj1.fieldA = " + obj1.fieldA + "\n obj2.fieldA = " + obj2.fieldA)
  }
}
class ScalaFieldOverrideA {
  val fieldA: Int = 10    // 编译后底层会生成public fieldA()
}
class ScalaFieldOverrideB extends ScalaFieldOverrideA {
  override val fieldA: Int = 20   // public fieldA()
}