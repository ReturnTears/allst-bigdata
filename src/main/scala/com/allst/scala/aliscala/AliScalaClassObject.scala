package com.allst.scala.aliscala

/**
  * 第六节：类和对象（一）
  * Created by June on 2018-05-24
  */
class AliScalaClassObject {
  /**
    * 采用关键字class定义、类成员必须初始化，否则会报错
    */
  // 公有成员变量
  var name:String = null
  // AliScalaClassObject类在编译后会生成AliScalaClassObject.class文件
  // 可以直接new操作创建Person对象
  def main(args: Array[String]): Unit = {
    val ali = new AliScalaClassObject()
    ali.name = ("yangyang");
    println(ali.name)
  }
}
// 也可以定义自己的getter/setter方法
class Person {
  // 定义私有成员
  private var privateName:String = null
  // getter方法
  def name = privateName
  // setter方法
//  def name_ = (name:String) {
//    this.privateName = name
//  }
}