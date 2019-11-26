package com.allst.scala.procase.service

import com.allst.scala.procase.bean.Customer

import scala.collection.mutable.ArrayBuffer

import util.control.Breaks._
/**
  * @author YiYa
  * @since 2019-11-25 下午 10:40
  */
class CustomerService {

    var array = ArrayBuffer(new Customer(1,"zhangsan",'m',18,"15012345678","zhangsan@sohu.com"))

    var customerId = 1

    def list(): ArrayBuffer[Customer] = {
        this.array
    }

    def add(cst: Customer): Boolean = {
        customerId += 1
        cst.id = customerId
        // 加入到ArrayBuffer
        array.append(cst)
        true
    }

    def del(id: Int): Boolean = {
        val index = findIndexById(id)
        if (index != -1) {
            array.remove(index)
            true
        } else {
            false
        }
    }

    def findIndexById(id: Int)= {
        var index = -1
        breakable {
            for (i <- 0 until array.length) {
                if (array(i).id == id) {
                    index = i
                    break()
                }
            }
        }
        index
    }
}
