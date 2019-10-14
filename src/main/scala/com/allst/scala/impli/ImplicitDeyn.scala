package com.allst.scala.impli

/**
  * 隐式转换给类动态增加方法
  * @author YiYa
  * @since 2019-10-14 下午 09:28
  */
object ImplicitDeyn {
  def main(args: Array[String]): Unit = {
    /**
      * 隐式转换方法
      * @param mySQLDeyn
      *                  该参数根本没有使用到, 这里的作用是为了让编译器找到该类型
      * @return
      */
    implicit def addDelete(mySQLDeyn: MySQLDeyn): MySQLDb = {
      new MySQLDb
    }

    val mysql = new MySQLDeyn
    mysql.insert()
    mysql.delete()    // 底层addDelete$1(mysql).delete()

    val db = new MySQLDb
    db.delete()
  }
}

class MySQLDeyn {
  def insert(): Unit = {
    println("insert")
  }
}
class MySQLDb {
  def delete(): Unit = {
    println("delete")
  }
}