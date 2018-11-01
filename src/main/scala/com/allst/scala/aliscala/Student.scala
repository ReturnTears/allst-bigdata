package com.allst.scala.aliscala

/**
  * @author June
  *         单例对象
  */
// 伴生对象
object Student extends App {
  private var studentNo: Int = 0
  def uniqueStudentNo() = {
    studentNo += 1
    studentNo
  }
  // 定义自己的apply方法
  def apply(name:String,age:Int)=new Student(name,age)
  // App其实是一种trait，它帮助我们定义了main方法。extends App后就不需要定义main方法
//  def main(args: Array[String]): Unit = {
//    println(Student.uniqueStudentNo())
//    val s = new Student("yangyang", 18)
//    // 直接访问到伴生类Student中的私有成员
//    println(s.sex)
//    // 直接利用类名进行对象的创建，这种方式实际上是调用前面的apply方法进行实现，
//    // 这种方式的好处是避免了自己手动new去创建对象
//    val  student = Student("yangY", 20)
//    println(student.name)
//    println(student.age)
//  }
      val  student = Student("yangY", 20)
      println(student.name)
      println(student.age)
      println(student.height)
}
// 定义Student类，该类称为伴生类，因为在同一个源文件里面，我们还定义了object Student
class Student(var name:String,var age: Int) extends StuInfo {
  private var sex:Int = 0
  // 直接访问到伴生对象的私有成员
  def printCompanionObject() = println(Student.studentNo)

  override var height: Int = 180

  override def eat: Unit = {
    println("eat by mouth")
  }
}
// 定义抽象类
abstract class StuInfo {
  // 抽象字段，一般类中定义字段的话必须初始化，而抽象类中则没有这要求
  var height:Int
  // 抽象方法
  def eat: Unit
}