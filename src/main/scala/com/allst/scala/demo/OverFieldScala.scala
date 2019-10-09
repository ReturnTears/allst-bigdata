package com.allst.scala.demo

/**
  * Scala字段的覆写
  * 1),def只能重写另一个def(即: 方法只能重写另一个方法)
  * 2),val只能重写另一个val属性或重写不带参数的def
  *
  * @author YiYa
  * @since 2019-10-09 下午 09:23
  */
object OverFieldScala {
  def main(args: Array[String]): Unit = {
    val sub1 = new FieldSup1
    println(sub1.say)
  }
}
class FieldSup1 {
  def say(): Int = {
    return 10
  }
}

/**
  * val只能重写另一个val属性或重写不带参数的def
  */
class FieldSub1 extends FieldSup1 {
  override val say: Int = 0   // 底层会生成public say()  相当于重写了父类的say()
}

/**
  * 如果要给name赋值的话就会导致name属性的设置和获取值不一致
  */
class FieldSup2 {
  val name: String = ""
  // var name: String = "" // 如果是var属性的话就会报错, 底层会生成public name()和public name_$eq()
}

class FieldSub2 extends FieldSup2 {
  override val name: String = "JUNE"  // 底层会生成public name()
}

abstract class absSup1 {
  var age: String   // 抽象的属性
}
class absSub extends absSup1 {
  //override var age: String = _ // 覆写一个抽象类的属性,override关键字可以省略
  var age:String = _
}

