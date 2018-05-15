package com.allst.scala.demo

/**
  * Scala的练习
  * @author June
  *         2018/04/19
  */
// 这时的gender相当于private[this]
class People(val id: String, var name: String, gender: String) {

}

object People {
  def main(args: Array[String]): Unit = {
    val p = new People("121", "June", "male")

    println(p.id + "" + p.name)

  }
}