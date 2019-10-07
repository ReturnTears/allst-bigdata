package com.allst.scala.demo;

/**
 * 回顾Java中的隐藏字段以及动态绑定机制
 * @author YiYa
 * @since 2019-10-08 上午 12:30
 */
public class OverField {
    public static void main(String[] args) {
        // 创建两个对象
        SubField sub = new SubField();
        System.out.println(sub.s);      // SubField

        System.out.println(((SuperField)sub).s);    // SuperField 强转依然可以访问到被隐藏的字段

        SuperField superField = new SubField();
        System.out.println(superField.s);   // SuperField

        System.out.println("----------------------------");

        // 执行的机制是先调用子类中的,再调用父类中的
        NumA a = new NumB();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}
// 父类
class SuperField {
    String s = "SuperField";
}
// 子类
class SubField extends SuperField {
    String s = "SubField";
}
// 测试Java动态绑定机制
class NumA {
    public int a = 10;
    public int sum() {
        return getI() + 10;
    }
    public int sum1() {
        return a + 10;
    }
    public int getI() {
        return a;
    }
}
class NumB extends NumA {
    public int a = 20;
    public int sum() {
        return getI() + 20;
    }
    public int sum1() {
        return a + 10;
    }
    public int getI() {
        return a;
    }
}