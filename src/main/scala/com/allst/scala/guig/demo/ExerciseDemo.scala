package com.allst.scala.guig.demo

/** 案例练习
  * @author JUNN
  * @since 2019-07-27 上午 09:50
  */
object ExerciseDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 假如还有97天,问XX个星期零XX天
      * 1:搞清楚需求
      * 2:思路分析
      * 3:代码实现
      */
     val day = 97

    printf("统计结果是%d个星期零%d天", day / 7, day % 7)

    val wd = 232.5
    val hs = 5.0 / 9 * (wd - 100)
    val forhs = hs.formatted("%.2f")
    printf(forhs)
  }
}
