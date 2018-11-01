package com.allst.scala.aliscala

/**
  * @author June on 2018-06-13
  *         包
  *         private成员同java是一样的，所有带该关键字修饰的成员仅能在定义它的类或对象中使用，在外部是不可见的
  */
class AliScalaPackage {


}

class StudentDemo(var name:String, var age: Int) {
  private var sex: String = "man"
  // 内部类
  class Course(val cName: String, val gpa: Float) {
    // 可以直接访问外部类的私有成员
    def getStudentSex(student: StudentDemo) = student.sex
  }
}

class Class {
  // 编译不过，sex是私有的
  //def getStudentSex(student: StudentDemo) = student.sex
}

object StudentDemo {
  private var studentNo: Int = 0
  def uniquesStudentNo() = {
    studentNo += 1
    studentNo
  }
  def apply(name:String, age:Int) = new StudentDemo(name, age)

  def main(args: Array[String]): Unit = {
    println(StudentDemo.uniquesStudentNo())
    val s = new StudentDemo("john", 29)
    // 直接访问伴生对象类Student中的私有成员
    println(s.sex)

    val s1 = StudentDemo("june", 22)
    println(s1.name)
    println(s1.age)

    // 使用内部类
    val c1 = new s1.Course("scala", 3.0f)
  }
}

