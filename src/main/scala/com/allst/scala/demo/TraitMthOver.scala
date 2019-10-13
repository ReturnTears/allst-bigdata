package com.allst.scala.demo

/**
  * 在特质中重写抽象方法特例
  * @author YiYa
  * @since 2019-10-13 下午 03:49
  */
object TraitMthOver {
  def main(args: Array[String]): Unit = {
    val mySQL5 = new MySQL5 with Db5 with File5
    mySQL5.insert(7)
  }
}

trait Operate5 {
  def insert(id: Int)
}

/**
  * 在子特质中重写了/实现了一个父特质的抽象方法, 但是同时调用super
  * 这是我们的方法不是完全实现, 隐藏需要声明为abstract override
  *
  * 这个时候super.insert(id)的调用就和动态混入的方式有密切的关系
  */
trait File5 extends Operate5 {
  abstract override def insert(id: Int): Unit = {
    println("将数据保存到文件中...")

    super.insert(id)
  }
}

trait Db5 extends Operate5 {
  def insert(id: Int): Unit = {
    println("将数据保存到数据库中")
  }
}

class MySQL5 {}