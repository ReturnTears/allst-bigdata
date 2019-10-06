package com.allst.scala.demo

/**
  * scala 继承
  * @author YiYa
  * @since 2019-10-06 下午 04:19
  */
object ExtendsDemo {
  def main(args: Array[String]): Unit = {
    val it = new It
    it.name = "程序员"
    it.itShow()
    it.showJobs()

    val tea = new Teacher
    tea.showAddr("ok")

    /**
      * 类型转换
      * classOf的使用,可以得到类名
      * x.getClass.getName 利用反射机制获取类名
      * isInstanceOf
      * asInstanceOf
      */
    println(classOf[String])
    val s = "King"
    println(s.getClass.getName)
    var jobs = new Jobs
    // 将子类引用赋值给父类(向上转型,自动)
    jobs = tea
    // 将父类的引用重新转换为子类引用(多态), 向下转型
    val jbs = tea.asInstanceOf[Teacher]
    jbs.showAddr("向下转型")

    test(it)
    test(tea)
  }

  // 多态的最佳实践
  def test(job: Jobs): Unit = {
    // 使用Scala中类型检查和转换
    if (job.isInstanceOf[It]) {
      job.asInstanceOf[It].showJobs()
    } else if (job.isInstanceOf[Teacher]) {
      job.asInstanceOf[Teacher].showAddr("多态实践, 类型转换")
    } else {
      println("类型转换失败...")
    }
  }
}

/**
  * 属性和方法加了protected,则该属性和方法只能在子类中使用
  * 属性和方法加了private,则该属性和方法只能在本类或伴生对象中使用
  */
class Jobs {
  var name: String = _
  var info: String = _
  private var nums: Int = _
  protected var addr: String = _
  def showJobs(): Unit = {
    println("工作名称为: " + this.name)
  }

  protected def showAddr(addr: String): Unit = {
    println("工作地点: " + addr)
  }
}

/**
  * 子类继承了父类的所有属性和方法, 只是私有的无法访问
  *
  */
class It extends Jobs {
  this.showAddr(addr: String)
  def itShow(): Unit = {
    println(this.name + "是一种工作名称")
  }
}

// 继承的方法重写
class Teacher extends Jobs {
  override def showAddr(addr: String): Unit = {
    super.showAddr(addr: String)
    println("子类重写父类中的方法..." + addr)
  }
}

