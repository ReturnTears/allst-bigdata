package com.allst.scala.aliscala

/**
  * @author June on 2018-06-14
  */
trait AliScalaTrait {
  def delete(id: String): Boolean
  def add(o: Any): Boolean
  def update(o: Any): Int
  def query(id: String): List[Any]
}
class ScalaTraitImpl extends AliScalaTrait with Cloneable {
  override def delete(id: String) = false

  override def add(o: Any) = true

  override def update(o: Any) = 1

  override def query(id: String) = List(1,2,3)
}