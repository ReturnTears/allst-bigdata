package com.allst.scala.demo

/**
  * 叠加特质
  * 混入多个特质时的特点
  * @author YiYa
  * @since 2019-10-13 上午 09:50
  */
object TraitOverlay {
  def main(args: Array[String]): Unit = {
    /**
      * 创建对象DataBases时动态混入Kays1和Vals1
      *
      * 当我们创建一个动态混入对象时, 其顺序是怎样的
      *
      * scala在叠加特质时会首先从后面的特质开始执行, 即从左到右
      */
    val db = new DataBases with Vals1 with Kays1
    println(db)

    /**
      * 当我们执行一个动态混入对象的方法, 其执行顺序是怎样的?
      *
      * 顺序是从右到左(方法的加载顺序相当于栈), 当执行到super时, 指的是左边的特质, 直到没有特质后super指的就是父特质
      */
    db.insert(22)
  }
}

trait Oper1 {
  println("oper1...")
  def insert(id: Int)
}

trait Data1 extends Oper1 {
  println("Data1")

  override def insert(id: Int): Unit = {
    println("insert data : " + id)
  }
}

trait Vals1 extends Data1 {
  println("Vals1")

  override def insert(id: Int): Unit = {
    println("in vals")
    super.insert(id)
  }
}

trait Kays1 extends Data1 {
  println("kays1")

  /**
    * super在动态混入时不一定是调用的父类
    * @param id
    */
  override def insert(id: Int): Unit = {
    println("in kays")
    super.insert(id) // 如果想直接调用父类中的insert方法, 如意如下
    //super[Data1].insert(id)
  }
}

class DataBases {}