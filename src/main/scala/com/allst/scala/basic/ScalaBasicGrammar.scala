package com.allst.scala.basic

/**
  * Scala 基础语法
  * @author YiYa
  * @since 2020/6/24-15:50
  */
object ScalaBasicGrammar {
  def main(args: Array[String]): Unit = {
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital)

    val facValue = factorial(5)
    println(facValue)

    val isUpper = isHasUpperCase("HelloScala")
    println(isUpper)
  }

  def factorial(x: BigInt): BigInt =
    if (x == 0) 1 else x * factorial(x - 1)

  /**
    * scala是高级的
    * @param name 参数
    * @return 结果
    */
  def isHasUpperCase(name: String): Boolean = {
    name.exists(_.isUpper)
  }
}
