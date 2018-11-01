package com.allst.scala.aliscala

/**
  * @author June on 2018-06-15
  */
object AliScalaSelfType {

}
// 自身类型
class SelfType {
  // self => 定义了this的别名，它是self type的一种特殊形式，self并不是关键字，可以是任何名称
  self =>
  val x = 2
  // self.x可以作为this.x使用
  def foo = self.x + this.x
}
// 内部类使用场景
class outerClass {
  out => // 定义一个外部类别名
  val v1 = "here"
  class InnerClass {
    println(out.v1)
  }
}

trait Self {
  def foo()
}
class DemoSelf {
  // self:Self => 要求DemoSelf在实例化时或定义DemoSelf的子类时
  // 必须混入指定的Self类型，这个Self类型也可以指定为当前类型
  self: Self =>
}
class Cla extends DemoSelf with  Self {
  def foo(): Unit = println("self type demo")
}
object SelfTypeDemo extends App {
  println(new Cla().foo())
}