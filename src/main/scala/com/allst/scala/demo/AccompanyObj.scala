package com.allst.scala.demo

/**
  * 伴生对象
  * 当在同一个文件中, 有class AccompPerson 和 object AccompPerson
  * class AccompPerson 称为伴生类, 将非静态的内容写到该类中, 编译后底层生成AccompPerson.class
  * object AccompPerson称为伴生对象, 将静态的内容写到该对象中, 编译后底层生成AccompPerson$.class
  * 对于伴生对象的属性或方法, 我们可以直接通过对象来调用:AccompPerson.xxx
  * @author YiYa
  * @since 2019-10-10 下午 09:44
  */
object AccompanyObj {
  def main(args: Array[String]): Unit = {
    println(AccompPerson.sex)
    val acc1 = new AccompPerson("aa")
    val acc2 = new AccompPerson("bb")
    val acc3 = new AccompPerson("cc")
    AccompPerson.joins(acc1)
    AccompPerson.joins(acc2)
    AccompPerson.joins(acc3)
    AccompPerson.showNum()

    // new 创建对象
    val pig = new Pig("猪宝贝")
    // 使用apply方法创建对象
    val p1 = Pig("笨笨猪")   // 自动触发apply(pname: String)
    val p2 = Pig()          // 自动触发apply()
    println("p1.name = " + p1.name)
    println("p2.name = " + p2.name)
  }
}
// 伴生类
class AccompPerson(cname: String) {
  var name: String = cname

}
object AccompPerson {
  var sex: Boolean = true
  var total: Int = 0
  def joins(accompPerson: AccompPerson): Unit ={
    printf("%s 小孩加入了人游戏\n", accompPerson.name)
    total += 1
  }
  def showNum(): Unit = {
    printf("当前玩游戏的小孩数量: %s \n", total)
  }
}

class Pig(pname: String) {
  var name: String = pname
}
object Pig {
  def apply(pname: String): Pig = new Pig(pname)
  def apply(): Pig = new Pig("乖乖猪")
}