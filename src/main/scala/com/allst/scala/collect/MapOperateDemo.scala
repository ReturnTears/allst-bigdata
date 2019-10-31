package com.allst.scala.collect

/**
  * map函数的操作
  *
  * 传统的方式和map函数方式的对比:
  * 传统的方式: 处理比较直接, 好理解, 但是不够简洁, 不高效, 没有体现函数式编程特点, 不利于处理复杂的数据业务逻辑
  * map方式:
  * @author YiYa
  * @since 2019-10-31 下午 11:20
  */
object MapOperateDemo {
  def main(args: Array[String]): Unit = {
    mth01()
    mth02()
  }

  def mth01(): Unit = {
    val list1 = List(1,2,3)
    var list2 = List[Int]()
    for (item <- list1) {
      list2 :+= item * 2
    }
    println(list2)
  }

  def mth02(): Unit = {
    val list1 = List(4, 5, 6)
    // 将list1集合中的元素依次遍历出来, 将各个元素传递给multiPle函数, 得到新的Int, 返回到一个新的集合返回
    val list2 = list1.map(multiPle)
    println(list2)
  }

  def multiPle(n: Int): Int = {
    n * 2
  }

  val mylist = myList()
  val mylist2 = mylist.map(multiPle)
  println(mylist2)
}
// 模拟实现map函数映射机制
class myList {
  val list1 = List(1,3,4,6)
  var list2 = List[Int]()
  def map(f: Int => Int): List[Int] = {
    for (item <- this.list1) {
      list2 :+= f(item)
    }
    list2
  }
}
// 伴生对象
object myList {
  // 重写apply方法
  def apply(): myList = new myList()
}
