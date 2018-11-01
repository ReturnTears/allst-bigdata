package com.allst.scala.aliscala

import java.io.PrintWriter
/**
  * @author June on 2018-06-15
  *         trait构造顺序
  *         trait与类的比较
  *         提前定义与懒加载
  *         trait扩展类
  *         self type
  */
object AliScalaStuTrait {
  def main(args: Array[String]): Unit = {
    /**
      * 匿名类
      * 在创建匿名类对象时，先调用的是Logger类的构造器，然后调用的是FileLogger的构造器。
      * 实际上构造器是按以下顺序执行的：
      * 1. 如果有超类，则先调用超类的构造器
      * 2. 如果有父trait，它会按照继承层次先调用父trait的构造器
      * 2. 如果有多个父trait，则按顺序从左到右执行
      * 3. 所有父类构造器和父trait被构造完之后，才会构造本类
      *
      */
    //new FileLogger {}.log("trait demo")
    // new Stu().log("trait demo log") // 编译时没有问题，但是运行时就会报错，具体原因就是构造器的执行顺序问题
//    val s = new {
//      // 提前定义,但是这种函数编写代码不优雅,难理解
//      override val filename = "file.log"
//    } with Stu
//    s.log("Predifined Variable")

    // lazy方式:lazy方式定义fileOutput只有当真正被使用时才被初始化
    val s = new Stu
    s.log("lazy method.")
  }
}

trait Logger {
  println("logger")
  def log(msg: String): Unit
}
// FileLogger里没有抽象的方法
trait FileLogger extends Logger {
  println("fileLogger")
  // 定义抽象成员变量
  val filename: String
  // 将方法定义为lazy方式
  lazy val fileOutput = new PrintWriter(filename)
  // 将抽象成员变量作为PrintWriter参数
//  val fileOutput = new PrintWriter(filename: String)
//  fileOutput.println("#")
  def log(msg: String): Unit = {
    fileOutput.print(msg)
    fileOutput.flush()
  }
}
class Per
class Stu extends Per with FileLogger {
  // 对FileLogger中的抽象字段进行重写
  val filename = "file.log"
}