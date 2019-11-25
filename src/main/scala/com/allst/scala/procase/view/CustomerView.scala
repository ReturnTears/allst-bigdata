package com.allst.scala.procase.view

import com.allst.scala.procase.bean.Customer
import com.allst.scala.procase.service.CustomerService

import scala.io.StdIn

/**
  * @author YiYa
  * @since 2019-11-25 下午 10:40
  */
class CustomerView {

    var loop = true
    var key: Char = ' '
    val customerService = new CustomerService()
    def mainMenu(): Unit = {
        do {
            println("-------客户信息管理软件-------")
            println("-------One添加客户-------")
            println("-------Two修改客户-------")
            println("-------Three删除客户-------")
            println("-------Four客户列表-------")
            println("-------Five其他-------")
            println("-------Six退出-------")

            println("请选择(1-6):")
            key = StdIn.readChar()
            key match {
                case '1' => this.add() // println("添加客户")
                case '2' => println("修改客户")
                case '3' => println("删除客户")
                case '4' => this.list() //println("查看客户")
                case '5' => println("其他客户")
                case '6' => this.loop = false
            }
        } while (loop)
        println("退出软件系统")
    }

    // 列表
    def list(): Unit = {
        println()
        println("-------客户信息列表-------")
        println("-------编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱-------")
        // for循环
        val customers = customerService.list()
        for (customer <- customers) {
            println(customer)
        }
        println("-------客户信息列表完成-------")
    }

    def add(): Unit = {
        println()
        println("-------添加客户-------")
        println("姓名:")
        val name = StdIn.readLine()
        println("性别:")
        val gender = StdIn.readChar()
        println("年龄:")
        val age = StdIn.readShort()
        println("电话:")
        val tel = StdIn.readLine()
        println("邮箱:")
        val email = StdIn.readLine()
        val customer = new Customer(name, gender, age, tel, email)
        customerService.add(customer)
        println("-------添加客户完成-------")
    }
}
