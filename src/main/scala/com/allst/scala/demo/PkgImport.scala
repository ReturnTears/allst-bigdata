package com.allst.scala.demo

// import scala.beans._  // _表示将该包的所有内容引入, 等价Java中的*

/**
  * 包的引入细节
  * @author YiYa
  * @since 2019-10-05 下午 11:44
  */
object PkgImport {

  def main(args: Array[String]): Unit = {

  }

}

class ImportUser {
  // 用时才引入
  import scala.beans.BeanProperty
  @BeanProperty var name: String = ""

  def testImp(): Unit = {
    // 可以使用选择器,选择引入包的内容,我们只引入HashMap, HashSet
    import scala.collection.mutable.{HashMap, HashSet}
    val map = new HashMap()
    val set = new HashSet()
  }

  def testImp2(): Unit = {
    // 重命名区分相同的类名称
    import java.util.{HashMap => JavaHashMap, List}
    import scala.collection.mutable.{HashMap}
    var map = new HashMap()
    var map2 = new JavaHashMap()
  }

  def testImp3(): Unit = {
    import java.util.{ HashMap => _, _} // 引入java.util包的所有类, 但是忽略HashMap类
  }
}