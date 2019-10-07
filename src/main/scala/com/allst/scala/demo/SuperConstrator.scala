package com.allst.scala.demo

/**
  * scala 中超类的构造
  * @author YiYa
  * @since 2019-10-06 下午 05:45
  */
object SuperConstrator {
  def main(args: Array[String]): Unit = {
    // 执行流程:Scala遵循先构建父类部分,在执行子类的构造器,
    val emp1 = new employee1()
    println("----------------------------")
    // 执行流程:Scala遵循先构建父类部分,在执行子类的构造器,后辅助构造器,
    val emp2 = new employee1("hello")
    println("----------------------------")
    // 扩展
    val emp3 = new employee2("world")
  }
}

// 父类
class Personals1 {
  var name = "Super"
  println("class personal...")
}
// 子类
class employee1() extends Personals1() {
  println("class employee")
  // 辅助构造器
  def this(name: String) {
    // 必须调用主构造器
    this
    this.name = name
    println("employee 辅助构造器")
  }
}

// 父类2
class Personals2(namea: String) {
  var name = namea
  println("class personal...")
  def this() {
    this("default name")
  }
}
// 子类2
class employee2() extends Personals2() {
  println("class employee")
  // 辅助构造器
  def this(name: String) {
    // 必须调用主构造器
    this
    this.name = name
    println("employee 辅助构造器")
  }
}