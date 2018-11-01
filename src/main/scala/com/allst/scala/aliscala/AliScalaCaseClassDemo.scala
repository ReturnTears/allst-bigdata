package com.allst.scala.aliscala

/**
  * @author June
  * @version 1.0
  */
object AliScalaCaseClassDemo {
  def main(args: Array[String]): Unit = {
    // case class会自动生成apply方法，从而省去了new操作
    val p: PersonHu = StuHu("huf", 18, 101)
    // match case 匹配语法
    p match {
      case StuHu(name, age, snum) => println(name + " - " + age + " - " + snum)
      case TeaHu(name, age, tnum) => println(name + " - " + age + " - " + tnum)
      case Nobody(name) => println(name)
    }

    val sc = SchoolClass("school1", TeaHu("yang", 32, 201), StuHu("HuF", 19, 203))
    sc match {
      case SchoolClass(_, _, StuHu(name, age, snum)) => println(name + " - " + age + " - " + snum)
      case _ => println("Nobody")
    }
  }
}
// 抽象类PersonHu
abstract class PersonHu
// case class Student
case class  StuHu(name: String, age: Int, snum: Int) extends PersonHu
// case class Teacher
case class TeaHu(name:String, age: Int, tnum: Int) extends PersonHu
// case class Nobody
case class Nobody(name: String) extends  PersonHu

// SchoolClass为接收多个PersonHu类型的类
case class SchoolClass(classDes:String, pers:PersonHu*)