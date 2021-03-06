package com.allst.scala.basic

/**
  * scala 内建控制结构
  *
  * @author YiYa
  * @since 2020/7/2-15:40
  */
object ScalaInlay extends App {
  val param = "scala"

  /*
    if表达式, 使用val的好处：1）、val提现了函数式的风格，2）、它可以更好地支持等效推论。
    在表达式没有副作用的前提下，引入的变量等效于计算它的表达式。
   */
  val rs = if (param.eq("scala")) true else false
  println(rs)

  /*
    while循环 / do-while循环
   */
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = a % b
      b = temp
    }
    b
  }
  def gcdLoop2(x: Long, y: Long): Long = {
    var a = x
    var b = y
    do {
      val temp = a
      a = a % b
      b = temp
    } while (a != 0)
    b
  }
  val wrs = gcdLoop(12, 5)
  val wrs2 = gcdLoop2(12, 5)
  println(wrs + " / " + wrs2)

  /*
    for表达式
    通过使用被称为发生器(generator)的语法"file <- filesHere", 遍历了filesHere的元素
    for表达式对任何类型的集合类都有效
   */
  val filesHere = (new java.io.File(".")).listFiles()
  for (file <- filesHere)
    println(file)

  for (i <- 1 to 4) print(i + " ")
  for (i <- 1 until 4) print(i + " ")

  /*
    过滤器filter
   */
  for (file <- filesHere if file.getName.endsWith(".xml"))
    println(file)
  // 或者
  for (file <- filesHere)
    if (file.getName.endsWith(".xml"))
      println(file)
  // 或者
  for (
    file <- filesHere
    if file.isFile; // 如果在发生器中加入超过一个过滤器，if子句必须用分号隔开
    if file.getName.endsWith(".xml")
  )
    println(file)

  /*
    嵌套枚举：如果加入多个<-子句，就得到了嵌套的"循环"

   */
  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".scala"); // 如果在发生器中加入超过一个过滤器，if子句必须用分号隔开
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + " : " + line.trim)
  grep(".*gcd.*")

  /*
    流间变量绑定
   */
  def grep2(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".scala"); // 如果在发生器中加入超过一个过滤器，if子句必须用分号隔开
      line <- fileLines(file);
      trimmed = line.trim
      if trimmed.matches(pattern)
    ) println(file + " : " + trimmed)

  /*
    制造新集合: 创建一个值去记住每一次的迭代，只要在for表达式之前加上关键字yield。
    for (子句) yield {循环体}
   */
  def scalaFiles =
    for {
        file <- filesHere
        if file.getName.endsWith(".scala")
    } yield file


}
