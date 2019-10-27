package com.allst.scala.collect

import scala.collection.mutable

/**
  * Queue
  *
  * @author YiYa
  * @since 2019-10-27 上午 10:54
  */
object QueueDemo {
  def main(args: Array[String]): Unit = {

    val q0 = new mutable.Queue[Int]
    q0 += 10
    println(q0)

    q0 ++= List(20, 30, 40)
    println(q0)

    val q1 = new mutable.Queue[Any]
    q1 += List(10, 20, 30)
    println(q1)

    // 从队列的头部删除一个元素并取出
    val q0Ele = q0.dequeue()
    println(q0Ele)

    // 从队列的尾部加入一个元素
    q1.enqueue(40, 40)
    println(q1)

    // 返回队列中的第一个元素
    println(q0.head)

    // 返回队列的最后一个元素
    println(q0.last)

    // 取出队尾的数据
    println(q0.tail)
    // 可以级联使用
    println(q0.tail.tail)



  }
}
