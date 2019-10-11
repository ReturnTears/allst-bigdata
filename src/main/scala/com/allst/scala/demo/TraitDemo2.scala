package com.allst.scala.demo

/**
  * trait案例
  * @author YiYa
  * @since 2019-10-11 下午 09:38
  */
object TraitDemo2 {
  def main(args: Array[String]): Unit = {
    val sheep = new Sheep
    sheep.sayHi()
    sheep.sayHello()
  }
}

/**
  * 当一个trait有抽象方法和非抽象方法时,
  * 一个trait在底层对应两个Trait02.class接口
  * 还对应Trait02$class.class Trait02$class抽象类
  */
trait Trait02 {
  // 抽象方法
  def sayHi()
  // 实现方法
  def sayHello(): Unit = {
    println("trait sayHello()")
  }
}

/**
  * 当trait有抽象和抽象类时,
  * class Sheep extends Trait02在底层对应class Sheep implements Trait02
  * 当在Sheep类中要使用Trait02的实现的方法, 就通过Trait02$class
  */
// 继承特质
class Sheep extends Trait02 {
  override def sayHi(): Unit = {
    println("Sheep sayHi()")
  }
}