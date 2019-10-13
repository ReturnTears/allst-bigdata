package com.allst.scala.demo

import com.allst.scala.demo

/**
  * Scala嵌套类
  *
  * @author YiYa
  * @since 2019-10-13 下午 09:43
  */
object ScalaNestClass {
  def main(args: Array[String]): Unit = {
    // 创建两个外部类实例
    val outer1: ScalaOuterClass = new ScalaOuterClass()
    val outer2: ScalaOuterClass = new ScalaOuterClass()

    // 在Scala中创建成员内部类的语法: 对象.内部类 的方式创建, 这里的语法可以看出在Scala中, 默认情况下内部类实例和外部对象关联
    val inner1 = new outer1.ScalaInnerClass
    val inner2 = new outer2.ScalaInnerClass

    // 创建静态内部类对象
    val staticInner = new ScalaOuterClass.ScalaStaticInnerClass

    inner1.info()

    val outer: ScalaOuter2Class = new ScalaOuter2Class
    val inner = new outer.ScalaInner2Class
    inner.info()
  }
}

// 外部类
class ScalaOuterClass {
  var name = "this is outer nature"
  private var sal = 123.45
  // 内部类
  class ScalaInnerClass {
    def info() = {
      // ScalaOuterClass.this相当于外部类的实例
      println("name : " + ScalaOuterClass.this.name + ", sal : " + ScalaOuterClass.this.sal)
    }
  }
}

object ScalaOuterClass { // 外部类的伴生对象
  class ScalaStaticInnerClass { // 静态内部类

  }
}

// 外部类
class ScalaOuter2Class {
  // 外部类的别名可以当作外部类的实例
  myOuter =>
  // 内部类
  class ScalaInner2Class {
    def info() = {
      // myOuter相当于外部类的实例
      println("name : " + myOuter.name + ", sal : " + myOuter.sal)
    }
  }
  var name = "this is outer property"
  private var sal = 678.90
}

object ScalaOuter2Class { // 外部类的伴生对象
class ScalaStatic2InnerClass { // 静态内部类

}
}