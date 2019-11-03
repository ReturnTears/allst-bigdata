package com.allst.scala.collect

/**
  * flatmap映射
  * @author YiYa
  * @since 2019-11-03 上午 07:43
  */
object FlatMapDemo {
  def main(args: Array[String]): Unit = {
    val sourceStr = List("Hi", "Scala", "Language")
    val destStr = sourceStr.map(upppers)
    println(destStr)
    val destStr2 = sourceStr.flatMap(upppers)
    println(destStr2)

    // filter
    val filterStr = sourceStr.filter(filterCap)
    println(filterStr)

    // reduceLeft, reduceRight: 递归调用
    val nums = List(1, 2, 8, 9)
    val sumNum = nums.reduceRight(sumTwo)
    println(sumNum)
    // ((1 - 2) - 8) - 9
    val diff1 = nums.reduceLeft(diffTwo)
    println(diff1)
    // (1 - (2 - (8 - 9)))
    val diff2 = nums.reduceRight(diffTwo)
    println(diff2)
    val diff3 = nums.reduce(diffTwo)
    println(diff3)

    // 求最小值
    println(nums.reduceLeft(minValue))

  }

  def upppers(s: String): String = {
    s.toLowerCase
  }

  def filterCap(s: String): Boolean = {
    //if (s.startsWith("S")) true else false
    s.startsWith("S")
  }

  def sumTwo(n1: Int, n2: Int): Int = {
    n1 + n2
  }

  def diffTwo(n1: Int, n2: Int): Int = {
    n1 - n2
  }

  // 求最小值
  def minValue(n1: Int, n2: Int): Int = {
    if (n1 > n2) n2 else n1
  }
}
