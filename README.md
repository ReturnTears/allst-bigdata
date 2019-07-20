>>2018/04/16
# 每天都要有Get的感觉
## Scala的学习之路， 加油 ！！！

### Part1
**1、学习Scala的原因**:
```
Spark是新一代内存级大数据计算框架，是大数据的重要内容
Spark就是使用Scala编写的。因此为了更好的学习Spark，需要掌握Scala这门语言

Scala是Scalable Language的简写， 十一么多范式(范式/编程方式[面向对象/函数式编程]的编程语言)

Spark的兴起带动了Scala语言的发展

Pizza和Scala极大地推动了Java编程语言的发展
jdk5.0的泛型,for循环增强,自动类型转换等都是从Pizza引入的新特性。
jdk8.0的类型推断, Lambda表达式就是从Scala引入的特性。 
```

### Part2
**2、java/scala/jvm的关系**
```
java代码 > javac编译器 > 得到.class字节码文件 > 将字节码文件放到JVM(JVM for windows / linux / unix)上运行 > 跨平台
Scala能使用Java的部分语法
Scala有自己特有的语法
Scala增加了函数式编程 / 偏函数 / 函数的柯里化 / 高阶函数 / 将函数作为参数传递
Scala对Java的类进行了包装
Scala代码 > Scalac编译器 > 得到.class字节码文件 > 将字节码文件放到JVM中运 > 跨平台
```

### Part3
**Scala**

### Part4
**Scala的特点:**
```
Scala是一门以Java虚拟机(JVM)为运行环境并将 面向对象 和 函数式编程 的最佳特性结合在一起的静态类型编程语言
1）Scala是一门多范式(multi-paradigm)的编程语言, Scala支持面向对象和函数式编程
2）Scala源代码(.scala)会被编译成Java字节码(.class),然后运行于JVM之上, 并可以调用现有的Java类库，实现两种语言的无缝对接
3）Scala单作为一门语言来看，非常的简洁高效 (舍弃了三元运算 ++ -- 等)
4）Scala的设计者式参考了Java的设计思想，可以说Scala是源于Java
```

### Part5
**Windows下搭建Scala开发环境**
```
1-Scala运行需要Java运行时库， 安装Scala需要首先安装JVM虚拟机并配置好环境变量, 推荐安装JDK1.8
2-http://www.scala-lang.org 不同系统选择不同版本
```

### Part6
**Linux下搭建Scala开发环境**
```
scala
```

### Part7
**Scala的开发工具**
```
IEDA(推荐)
Eclipse

默认情况下, Scala不支持Scala的开发, 需要在IDEA中安装Scala插件
```

### Part8
**Scala快速开发入门**

### Part9
**IDEA开发Scala入门**
```
IDEA创建maven项目, 项目中添加上Scala的SDK包,一般在本地安装了Scala, 将安装环境配置到IDEA中就可以了

```

### Part10
**Java模拟Scala运行流程机制**
```

```

### Part11
**Scala程序开发注意事项(重点)**
```
1 - Scala源文件以".scala"为扩展名
2 - Scala程序的执行入口时main()函数
3 - Scala语言严格区分大小写
4 - Scala犯方法由一条条语句构成, 每个语句后不需要分号(Scala语言会在每行后面自动加分号), 体现了Scala的简洁性
5 - 如果在同一行有多条语句, 除了最后一条语句不需要分号， 其他行语句需要分号

```
**Scala语言转义字符(escape char)**
```
1 - \t  : 一个制表符, 实现对齐的功能      println("name\tage")
2 - \n  : 换行符                      println("name\nage")
3 - \\  : 一个\                      println("C:\\xx")
4 - \"  : 一个"                      println("name\"age\"")
5 - \r  : 一个回车                    println("name\r age")
```

**Scala语言输出的三种方式**
``` scala
1 - 字符串通过 + 号连接 (似Java)
2 - printf用法 (似C)  字符串通过%传值  (%s-String %d-十进制)
3 - 字符串通过$引用 (似PHP)
```

### Part12
**Scala源码查看关联**
``` scala
在使用Scala过程中, 为了搞清楚Scala底层机制, 需要查看源码:
1 - 查看源码, 选择要查看的方法或者类, 输入ctrl + b   (将鼠标指针放到要查看的方法或类上, 输入ctrl + b)
2 - 关联源码, 将Attach Source指定到Scala的源代码解压路径下即可

```
### Part13
**注释(_comment_)**
```text
用于注释说明解释程序的文字就是注释, 注释提高了代码的可阅读性
注释是一个程序员必须要具有的良好编码习惯，将自己的思想通过注释先整理出来，再用代码去体现
Scala中的注释类型:
1 - 单行注释
2 - 多行注释
3 - 文档注释
    scaladoc -d 文档存放路径 类名称  (最好是直接切换到当前类的路径下)
    scaladoc -d E:\test\doc HelloScala.scala

```

### part14
**Scala规范的代码风格**
```text
正确的缩进和空白
1 - 使用一次tab操作, 实现缩进，默认整体向右移动, 使用shift+tab整体左移
2 - 使用ctrl + alt + l 格式化代码
3 - 运算符的两边习惯性加一个空格
4 - 一行代码最长不要超过80个字符，超过则使用换行展示，尽量保持格式优雅

```
**scala官方编程指南**
```text

```

### Part15
**Scala变量**
```
变量是程序的基本组成单位,变量相当于内存中一个数据存储控件的表示, 你可以把变量看做是一个房间的门牌号，
通过门牌号我们可以找到房间, 而通过变量名可以访问到变量

声明/定义(指声明的同时给变量赋值)变量的关键字:
val: 不可变类型, 没有线程安全问题(推荐使用), 效率较高
var: 可变类型
再Scala中小数默认为Double类型，整数默认为Int类型
isInstanceOf判断数据类型

val | var 变量名 [:变量类型] = 变量值
注意:
声明变量时，类型可以省略(编译器自动推导,即类型推导)
类型确定后，就不能修改，说明Scala是强数据类型语言
再声明/定义一个变量时，可以使用var或者val来修饰, var修饰的变量可改变, val修饰的变量不能改变
val修饰的变量再编译后，等同于加上final

```



### 快捷键  shortcut key
```text
格式化文档:
1 - ctrl + alt + l  格式化代码

```





https://www.bilibili.com/video/av39126512?p=17