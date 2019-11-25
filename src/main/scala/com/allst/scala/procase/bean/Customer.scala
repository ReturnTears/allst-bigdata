package com.allst.scala.procase.bean

/**
  * @author YiYa
  * @since 2019-11-25 下午 10:30
  */
class Customer {
    // 属性
    var id: Int = _
    var name: String = _
    var gender: Char = _
    var age: Short = _
    var tel: String = _
    var email: String = _

    // 设计一个辅助构造器
    def this(id: Int, name: String, gender: Char, age: Short, tel: String, email: String) {
        this
        this.id = id
        this.name = name
        this.gender = gender
        this.age = age
        this.tel = tel
        this.email = email
    }

    def this(name: String, gender: Char, age: Short, tel: String, email: String) {
        this
        this.name = name
        this.gender = gender
        this.age = age
        this.tel = tel
        this.email = email
    }

    override def toString: String = {
        this.id + "\t\t" + this.name + "\t\t" +
        this.gender + "\t\t" + this.age + "\t\t" +
        this.tel + "\t\t" + this.email
    }
}
