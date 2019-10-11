package com.allst.scala.demo

/**
  * Trait Mix
  * @author YiYa
  * @since 2019-10-11 下午 11:24
  */
object TraitMix {
  def main(args: Array[String]): Unit = {
    // 在不修改原有class的情况下,任然可以使用扩展方法,  这里用到了特质的混入
    val db = new OracleDb with TraitOper
    db.showInfo(22)

    val mySQL = new MySQL8 with TraitOper
    mySQL.showInfo(77)

    val mySQL7 = new MySQL7 with TraitOper {
      override def say(): Unit = {
        println("say")
      }
    }
    mySQL7.showInfo(88)
    mySQL7.say()
  }
}

trait TraitOper {
  def showInfo(id: Int): Unit = {
    println("插入数据 = " + id)
  }
}

class OracleDb {

}

abstract class MySQL8 {

}

abstract class MySQL7 {
  def say()
}