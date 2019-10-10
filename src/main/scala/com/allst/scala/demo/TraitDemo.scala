package com.allst.scala.demo

/**
  * trait特质
  * @author YiYa
  * @since 2019-10-10 下午 11:48
  */
object TraitDemo {
  def main(args: Array[String]): Unit = {
    val c = new TraitSub2
    c.getConn()
  }
}
object T1 extends Serializable {

}
object T2 extends Cloneable {

}

// 定义trait
trait TraitDm {
  def getConn ()
}

class TraitSup1 {}
class TraitSub1 extends TraitSup1 {}
class TraitSub2 extends TraitSup1 with TraitDm {
  override def getConn(): Unit = {
    println("trait 中获取连接方法")
  }
}

class TraitSup2 {}
class TraitSub3 extends TraitSup2 {}
class TraitSub4 extends TraitSup2 with TraitDm {
  override def getConn(): Unit = {
    println("trait 中获取连接的方法")
  }
}