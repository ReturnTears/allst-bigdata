package com.allst.scala.basic

/**
  * 函数式编程风格
 *
  * @author YiYa
  * @since 2020/6/28-14:41
  */
object FuncExParams extends App {

  /**
    * 使用了var, 属于指令式风格
    * @param args 参数
    */
  def printArgs1(args: Array[String]) : Unit = {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }

  /**
    * 函数式风格
    * @param args 参数
    */
  def printArgs2(args: Array[String]) : Unit = {
    for (arg <- args) {
      println(arg)
    }
  }

  /**
    * 函数式风格
    * @param args 参数
    */
  def printArgs3(args: Array[String]) : Unit = {
    args.foreach(println)
  }

  def formatArgs(args: Array[String]) = args.mkString(",")

  val res = formatArgs(Array("zero", "one", "two"))
  assert(res == "zero,one,two") // 如何返回结果为假，抛出AssertionError,否则assert就什么都不做，安静的返回。
  // println(res)

}

