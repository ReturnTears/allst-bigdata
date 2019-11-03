package com.allst.scala.collect

import scala.collection.mutable

/**
  * @author YiYa
  * @since 2019-11-03 上午 09:20
  */
object TotalNumScala {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAABBBBBCCCCCDDDDD"
    val map = sentence.foldLeft(Map[Char, Int]())(charCount)
    println(map)

    // 创建一个可变map作为左折叠的第一个参数, 可变的map以及存在
    val map2 = mutable.Map[Char, Int]()
    sentence.foldLeft(map2)(charCount)
    println(map2)
  }

  // 使用不可变map实现
  def charCount(map: Map[Char, Int], char: Char): Map[Char, Int] = {
    map + (char -> (map.getOrElse(char, 0) + 1))
  }
  // 使用可变集合, 效率更高
  def charCount(map: mutable.Map[Char, Int], char: Char): mutable.Map[Char, Int] = {
    map += (char -> (map.getOrElse(char, 0) + 1))
  }
  // 经典案例: val lines = List("Ai say Hello", "Ai say good bye")
  // 使用映射集合list, 统计各个单词出现的次数,并按出现次数排序
}
