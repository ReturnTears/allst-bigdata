package com.allst.scala.comm_use

/**
  * 转换方式枚举
  *
  * @author YiYa
  * @since 2020/9/15-14:32
  */
object TransformType extends Enumeration {

  type TransformType = Value
  // 先删除原有数据再导入
  val DeleteAndTransform = Value(-1)
  // 直接转换
  val DirectTransform = Value(0)
  // 合并转换
  val UnionTransform = Value(1)
}
