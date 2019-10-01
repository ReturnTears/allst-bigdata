package com.allst.scala.demo

/**
  * pkg,
  * 在Scala中自动引入的包: java.lang.* scala包 Predef包
  * @author YiYa
  * @since 2019-10-01 下午 09:53
  */
object PkgDemo {
  def main(args: Array[String]): Unit = {
    val pkg1 = new com.allst.scala.demo.pkgOne.Pkg1Demo
    val pkg2 = new com.allst.scala.demo.pkgTwo.Pkg2Demo


    println(pkg1)
    println(pkg2)
  }
}
