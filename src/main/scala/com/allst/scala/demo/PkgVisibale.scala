package com.allst.scala.demo

/**
  * Scala包的可见性
  * @author YiYa
  * @since 2019-10-05 下午 10:58
  */
object PkgVisibale {
  def main(args: Array[String]): Unit = {
    val c = new Clerk()
    c.showInfo()
    // 伴生对象中时类似Java的静态部分
    Clerk.test(c)
  }
}

// 类
class Clerk {
  var name: String = "Jack" // 底层映射的是 private String 可读可写
  private val sal: Double = 7022.07 // private 可读不可写
  def showInfo(): Unit = {
    // 私有可以访问
    println("name = " + name + ", sal = " + sal)
  }
}

// 当一个文件中出现了相同的class名称和object名称(class 称为伴生类, object称为伴生对象)
//
object Clerk {
  val jurisdiction = new ClerkJurisdiction
  def test(c: Clerk): Unit = {
    // 伴生对象可以访问伴生类中的属性及私有属性
    println("test name = " + c.name + ", sal = " + c.sal + ", nickname = " + jurisdiction.nickname)
  }
}

class ClerkJurisdiction {
  // 增加一个包访问权限, private[demo]表示仍然是private,在demo包及其子包下可以使用nickname,相当于扩大了访问范围
  private[demo] val nickname = "WaWa"
}