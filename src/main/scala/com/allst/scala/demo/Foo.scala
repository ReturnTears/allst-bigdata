package com.allst.scala.demo

/**
  * 在初始化变量时,可以使用下划线作为占位符.这在类创建变量时可以工作的,但是在其他情况下,如在方法中定义变量,是无效的
  * 对于数值类型,这不算个问题--可以赋值为0,但是对于其他类型,可以采用这种方法:
  * Var name = null.asInstanceOf[String]
  *
  * @author JUNN
  * @since 2019-09-01 上午 08:52
  */
class Foo {
  var a: Short = 0
  var b: Short = _
  var name = null.asInstanceOf[String]

  /**
    * 比较两个浮点数的值, 自定义一个能容忍一定误差的浮点数比较的函数
    * @param x  parma1
    * @param y  parma2
    * @param precision  精度
    * @return
    */
  def ~=(x: Double, y: Double, precision: Double)  = {
    if ((x - y).abs < precision) true else false
  }
}
