package com.allst.scala.aliscala

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton

/**
  * @author June on 2018-06-15
  *         高阶函数
  */
object AliScalaHigherFunc {

  // 函数参数

  // 返回值是函数的函数

  // SAM转换
  /**
    * 在java的GUI编程中，在设置某个按钮的监听器的时候，
    * 我们常常会使用下面的代码（利用scala进行代码开发）
    */
  var counter = 0;
  val button = new JButton("click")
  button.addActionListener(
    /**
      * 这部分称为样板代码，即在任何实现该接口的类中都需要这样用，重复性较高，
      * 由于ActionListener接口只有一个actionPerformed方法，
      * 它被称为simple abstract method(SAM)。
      * SAM转换是指只给addActionListener方法传递一个参数
      */
    new ActionListener { // 匿名内部类
    override def actionPerformed(e: ActionEvent): Unit = {
      counter += 1
    }
  })
  // 上面有一个隐式转换
}
