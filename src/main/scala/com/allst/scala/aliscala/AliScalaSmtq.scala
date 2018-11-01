package com.allst.scala.aliscala
import scala.collection.immutable.Queue
import scala.collection.mutable
import scala.collection.mutable.Stack
/**
  * Set、Map、Tuple、队列操作实战
  * @author June
  * @version 0.0.1
  */
object AliScalaSmtq {

  def main(args: Array[String]): Unit = {
    /**
      * Set操作实战
      * Set（集）是一种不存在重复元素的集合，它与数学上定义的集合是对应的
      */
    val numsSet = mutable.Set(3,0,5)
    // Set在插入元素时并不保元素的顺序
    numsSet + 6
    for (i <- numsSet) println(i)
    // 如果对插入的顺序有着严格的要求，则采用scala.collection.mutalbe.LinkedHashSet来实现
    val linkedHashSet=scala.collection.mutable.LinkedHashSet(3.0,5)
    linkedHashSet + 8

    /**
      * Map操作实战
      * ->操作符，左边是key,右边是value
      */
      // 不可变
    val Stu = Map("name" -> "yang", "age" -> 18)
    // 可变,mutable Map可变，比如可以将其内容清空clear()
    val stu = mutable.Map("yang" -> 18, "hu" -> 20, "June" -> 22)
    // 遍历1
    for (i <- stu) println(i)
    // 遍历2
    Stu.foreach(e => {
      val (k, v) = e; println(k + ":" + v)
    })
    // 遍历3
    stu.foreach(e => println(e._1 + ":" + e._2))
    // 添加值
    stu.put("July", 21)
    // 获取
    stu.get("July")
    // 通过模式匹配得到最终的结果
    def show(x : Option[Int]) = x match {
      case Some(s) => s
      case None => "????"
    }
    show(stu.get("July"))

    /**
      * 元组操作实战
      * Map是键值对的集合，元组则是不同类型值的聚集
      */
    ("hello","china","beijing")
    var tuple = ("hi", "yang", 18)
    // 访问元组内容
    val a = tuple._1
    println(a)
    // 通过模式匹配获取元组内容
    val (first, second, third) = tuple

    /**
      * 队列操作实战
      */
    // immutable
    var queue = Queue(1,2,3)
    // 出队
    queue.dequeue
    // 入队
    queue.enqueue(4)
    // mutable
    var que = mutable.Queue(1,2,3,4,5)
    // 入队
    que += 5
    // 集合方式
    que ++= List(6,7,8,9)

    /**
      * 栈操作实战
      */
    // 创建方式
    var stack = new Stack[Int]
    var sta = Stack(1,2,3)
    // 入栈
    sta.push(4)
    // 出栈
    sta.top
  }
}
