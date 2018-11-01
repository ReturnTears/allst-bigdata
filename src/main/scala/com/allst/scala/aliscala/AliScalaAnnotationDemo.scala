package com.allst.scala.aliscala

/**
  * @author June 
  *         2018-07-11
  * @version 1.0
  */
object AliScalaAnnotationDemo {
  def main(args: Array[String]): Unit = {
    var b = new B()

  }
}
abstract class A {
  // native用于标记 cplusplusMethod为c或c++中实现的本地方法
  @native def cplusplus()
}
//标记B可被序列化
//注解声明序列化版本
//@SerialVersionUID(1000330L)
//@Serializable
class B extends A {
  /**
    * 同java一样，采用@+注解关键字对方法、变量
    * 类等进行注解标识
    * 下面的注解用于标识getName方法在未来会被丢弃
    * 不推荐使用
    * @return
    */
//  @deprecated def getName() = "Class B"
  //volatile注解标记变量name非线程安全
  @volatile var name: String = "B"
  // transient注解用于标记变量age不被序列化
  @transient var age: Int = 40
}