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

### Part15 / 16 /17
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
1 - 声明变量时，类型可以省略(编译器自动推导,即类型推导)
2 - 类型确定后，就不能修改，说明Scala是强数据类型语言
3 - 再声明/定义一个变量时，可以使用var或者val来修饰, var修饰的变量可改变, val修饰的变量不能改变
4 - val修饰的变量再编译后，等同于加上final
5 - var修饰的对象引用可以改变,val修饰的则不可以改变, 但对象的状态(值)却是可以改变的。
6 - 声明变量时, 需要初始值

程序中 + 号的使用  (同Java)
1 - 当左右两边都是数值型时, 则做加法运算
2 - 当左右两边有一方为字符串, 则做拼接运算

```
**Scala数据类型**
```
1 - Scala与Java有着相同的数据类型,再Scala中数据类型都是对象, 也就是说Scala没有Java中的原生类型
2 - Scala数据类型分为两大类AnyVal(值类型) 和 AnyRef(引用类型), 注意: 不管是AnyVal还是AnyRef都是对象
3 - 相对于Java的类型系统, Scala要更复杂, 也正是这些复杂多变的类型系统才让面向对象编程和函数式编程完美的融合在一起
```
![Image](https://github.com/ReturnTears/allst-scala/blob/master/cimg/Scala_data_type.png)
```text
对上图的解释如下:
1 - 在Scala中有一个根类型, Any是所有类型的父类
2 - Scala中一切皆为对象,分为两大类型AnyVal(值类型),AnyRef(引用类型), 它们都是Any的子类型
3 - Null类型是Scala的特别类型,他只是一个值null, 它是bottom class, 是所有AnyRef类型的子类型
4 - Nothing类型也是bottom class, 它是所有类型的子类型, 在开发中可以将Nothing类型的值返回给任意变量或者函数, 在抛出异常时使用较多
5 - 在Scala中仍然遵守低精度向高精度的值自动转换(implicit conversion)隐式转换

```

### Part18  / 19
**Scala数据类型列表**
```
数据类型          |           描述
----            |           ----
Byte            |           8位有符号补码整数。整数区间为-128 ~ 127           -2的7次方 ~ 2的7次方 - 1
Short           |           16位有符号补码整数。整数区间为-32768 ~ 32767
Int             |           32位有符号补码整数。整数区间为-2147483648 ~ 2147483647
Long            |           64位有符号补码整数。整数区间为-9223372036864775808 ~ 9223372036854775807
Float           |           32位，IEEE754标准的单精度浮点数
Double          |           64位，IEEE754标准的双精度浮点数
Char            |           16位无符号Unicode，区间值为U+0000到U+FFFF
String          |           无符序列
Boolean         |           true或false
Unit            |           表示无值，和其他语言中void等同。用作不返回任何结果的方法的结果类型，Unit是一个实例值，写成()
Null            |           null
Nothing         |           Nothing类型在Scala的类层级的最低端，它是任何其他类型的子类型
Any             |           Any是所有其他类的超类
AnyRef          |           AnyRef类是Scala里所有引用类reference class的基类
```

补充:
最高位为符号为 **[0 1]**
·0表示整数
·1表示负数

**整数的使用细节:**
```
1 - Scala个整数类型有固定的表示范围和字段长度, 不受具体的OS的影响, 以保证Scala程序的可移植性性
2 - scala的整型 **常量/字面量** 默认为Int型， 声明Long型 常量/字面量 须后面加"l"或者“L”
3 - Scala程序中变量常声明为Int型, 除非不足以表示大数, 才使用Long
```
**浮点数使用细节:**
```
1 - 与整型类似,Scala浮点数类型也有固定的表示范围和字段长度,不受具体OS的影响
2 - Scala的浮点数类型**常量**为Double型, 声明Float型常量,须后加'f'或'F'
3 - 浮点型常量有两种表示方式:
    十进制数形式:5.12     512.0f  .512 (必须有小数点)
    科学计数法形式:5.12e2 = 5.12 × 10^2  5.12E-2 = 5.12 ÷ 10^2
4 - 通常情况下,应该使用Double型,因此他比Float型更精确(Float大致精确到小数点后7位)
```

### Part20
**字符类型(Char)**
```
字符类型可以表示单格字符,字符类型是Char,16位无符号Unicode(Unicode编码包含了assci码)字符(2个字节),区间值为U+0000到U+FFFF

字符类型使用细节:
1 - 字符常量是使用单引号('')括起来的单格字符; var c1 = 'a'
2 - Scala也允许使用转义字符'\'来将其后的字符转变为特殊字符型常量
3 - 可以直接给Char赋一个整数,然后输出时,回按照对应的Unicode字符输出['\u0061' 97]
4 - Char类型是可以进行运算的,详单与一个整数,因为它都对应有Unicode码

```
**注意:**
```
当把一个计算的结果赋值一个变量,则编译器会进行类型转换及判断(即会查看范围+类型)
当把一个字面量赋值一个变量,则编译器会进行数值范围判断
```

### Part21
**布尔类型:Boolean**
```
基本介绍:
1 - 布尔类型也叫Boolean类型, Boolean类型数据只允许取值true和false
2 - Boolean类型占1个字节
3 - Boolean类型适用于逻辑运算, 一般用于程序流程控制
> if条件控制语句
> while循环控制语句
> do-while循环控制语句
> for循环控制语句

```

**Unit类型 Null类型 Nothing类型**
```
使用细节和注意事项:
1 - Null类型只有一个实例对象,null,类似于Java的null引用.null可以赋值给任意引用类型(AnyRef),但是不能赋值给值类型(AnyVal)
2 - Unit类型用来标识过程,也就是没有明确返回值的函数.由此可见,unit类似于Java的void.Unit只有一个实例,(),这个实例也没有实质的意义
3 - Nothing,可以作为没有正常返回值的方法的返回值类型,非常直观的告诉你这个方法不会正常返回,而且由于Nothing是其他任意类型的子类,他还能跟要求返回值的方法兼容
```

### Zuoye Page
```text
1 - 在Scala REPL(Read evaluateion print loop)中,计算3的平方根,然会再对该值求平方, 这个结果和3相差多少?
    scala> var a = 3
    a: Int = 3
    
    scala> import scala.math
    import scala.math
    
    scala> val b = math.sqrt(a)
    b: Double = 1.7320508075688772
    
    scala> val c = b * b
    c: Double = 2.9999999999999996
    
    scala> val d = c - a
    d: Double = -4.440892098500626E-16
    
2 - Scala语言的sdk是什么?
    开发工具包

3 - Scala环境变量配置及其作用
    注意Windows和LInux下的环境配置区别
    作用是方便开发和使用

4 - Scala程序的编写,编译,运行各个步骤是什么? 能否一步执行?
    
    
5 - Scala程序编写的规则
    同Java, 可以不带分号

6 - 简述: 在配置环境\编译\运行各个步骤中常见错误
    

7 - 如何检测一个变量是val还是var?  
    思路:分别定义一个val和var变量, 重新赋值成功的是var变量, 不能重新赋值的是val变量
    isInstanceOf


8 - Scala允许你用数字去乘一个字符串,去REPL中试一下"crazy" * 3? 这个步骤做什么?再Scaladoc中如何找到这个操作?
    scala> val e = "crezy"
    e: String = crezy
    
    scala> e * 3
    res0: String = crezycrezycrezy

9 - 10 max 2的含义是什么? max方法定义下那个类下?
    scala> 10 max 2
    res1: Int = 10
    或者
    scala> 10.max(2)
    返回两个数的最大值
    max方法定义在RichInt, Int
    
10 - length计算2的1024次方(使用BigInt计算)
    scala> val a = BigInt(2)
    a: scala.math.BigInt = 2
    
    scala> a.pow(1024)
    res0: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216

11 - 在Scala中如何获取字符串"Hello"的首字符和尾字符
    Java,JavaScript可以使用substring
    scala> val b = "Hello"
    b: String = Hello
    
    scala> b.take(1)
    res1: String = H
    
    scala> "Hello"(0)
    res4: Char = H
    
    scala> b.reverse.take(1)
    res2: String = o
    
    scala> b.takeRight(1)
    res3: String = o

```

### Part24
**值类型转换**
```
自动类型转换细节说明:
1 - 有多种类型的数据混合运算时,系统首先会自动将所有数据转换成容量最大的那种数据类型,然后在进行计算
2 - 当我们把精度(容量)大的数据类型赋值给精度(容量)小的数据类型时就会报错,反之,就会进行自动类型转换
3 - (byte,short)和char之间不会相互转换,(byte和short可以)
4 - byte,short,char它们三者可以计算,在计算时首先转换为int类型
5 - 自动提升原则, 表达式结果的类型自动提升为操作数中最大的类型
```
**高级隐式转换和隐式函数**
```
todo
```
**强制类型转换**
```
自动类型转换的逆过程,将容量大的数据类型转换为容量小的数据类型,使用时需要加上强制类型转换函数,
但可能造成精度降低或溢出, 格外注意
强制类型转换细节说明:
1 - 当进行数据的从大到小,就需要使用强制类型转换
2 - 强制符号只针对于最近的操作数有效,往往会使用小括号提升优先级
    val num1:Int = 10 * 3.5.toInt + 6 * 1.5.toInt   // 36
    val num2:Int = (10 * 3.5 + 6 * 1.5).toInt       // 44
3 - Char类型可以保持int的常量值,但不能保存Int的变量值,需要强转
4 - Byte和Short类型在进行运算时,当作int类型处理
```

### Part26
**值类型和String类型的转换**
```
在开发中我们经常需要将基本数据类型转成String类型.或者将String类型转换成基本数据类型
基本数据类型转String类型:
语法:将基本数据类型的值 + ""即可, String str = true + ""; 或者 4.5 + ""; 或者 1000 + ""
String类型转基本数据类型:
语法: 通过基本类的String.toXXX方法即可
注意事项:
1 - 在将String类型转成基本数据类型时, 要确保String类型能转成有效的数据. 可以把"123"转换成一个整数,但是不能把"hello"转成整数
2 - 如何把"12.5"转成Int ,   在Scala中不是将小数点后的数字进行截取,而是会抛出异常
```

### Part27 
**标识符的命名规范**
```
标识符概念
1 - Scala对各种变量\方法\函数等命名时使用的字符序列化称为标识符
2 - 凡是自己可以起名字的地方都叫标识符
```
**标识符的命名规则(Remenber)**
```
Scala中的标识符声明, 基本和Java是一致,细节上有所不同.
1 - 首字符为字母, 后续字符任意字母和数字,美元符号,可后接下划线_
2 - 不能以数字开头
3 - 首字符为操作符(+ - * /), 后续字符也需要跟操作符, 至少一个(反编译)
4 - 操作符不能再标识符中间和最后
5 - 用反引号`...`包括的任意字符串,即使是关键字(39个)也可以[true]

在Scala中Int不是保留字(关键字),而是预定义标识符,可以是作为标识符,但是不推荐
不能直接单独使用下划线_作为标识符
val `true` = "Hello Scala"
println(`true`)
注意事项:
1 - 包名:尽量采取有意义的包名,简写,有意义
2 - 变量名\函数名\方法名采用驼峰命名法

```
**Scala关键字(39个)**
```
package import class object trait extends with type forSome
private protected abstract sealed final implicit lazy override
try catch finally throw
if else match case do while for return yield
def val var
this super
new true false null
```

### Part28
**运算符**
```
运算符是一种特殊的符号,用以表示数据的运算\赋值和比较等
1 - 算术运算符
    算术运算符(arithmetic)是对数值类型的变量进行运算的,在Scala程序中使用非常多
    + - * / % (+还可以表示'正号','字符串相加',-还可以表示'负号'), 
    在Scala中么有++ --, 而是使用了 +=1 和 -=1
    % 的运算规则: a % b = a - a/b * b
    10 % 3      // 1
    -10 % 3     // -1
    -10 % -3    // -1
    10 % -3     //  1
2 - 赋值运算符
    赋值运算符就是将某个运算后的值赋给指定的变量
    = += -= *= /= %=
    <<= 左移后赋值   a <<= b 等价于 a = a << b
    >>= 右移后赋值
    &= 按位与后赋值
    ^= 按位异或后赋值
    |= 按位或后赋值
    赋值运算的特点:
    1 - 运算顺序从右往左
    2 - 赋值运算符的左边只能是变量, 右边可以是变量,表达式,常量值,字面量
    3 - 复合赋值运算符等价于下面的效果 a += b ==> a = a + b
3 - 比较运算符(关系运算符)
    关系运算符的结果都是Boolean类型,true, false
    关系表达式经常用在if结构的条件或循环结构的条件中
    关系运算符的使用和Java一样
    == != < > <= >=
    
    细节说明:
    1 - 关系运算符的结构都是Boolean类型,true,false
    2 - 关系运算符组成的表达式,我们称为关系表达式, a > b
    3 - 比较运算符"=="不能写成"="
    4 - 使用陷阱: 如果两个浮点数进行比较,应当保证数据类型一致
4 - 逻辑运算符
    用于连接多个条件(一般来讲是关系表达式),最终的结果也是一个Boolean值
    && || !
5 - 位运算符
    & 按位与
    | 按位或
    ^ 按位异或
    ~ 按位取反
    << 左移
    >> 右移
    >>> 无符号右移
Scala不支持三目运算, 在Scala中使用if-else的方式实现,
Scala在这里的设计理念是:一种事情尽量只有一种方法完成,这样可以让代码风格更加统一
```
**运算符的优先级**
```
1 - 运算符有不同的优先级,所谓优先级就是表达式运算中的运算顺序
2 - 只有单目运算符\赋值运算符是从右往左运算的
3 - 运算符优先级和Java一样
L = 从左到右
R = 从右到左
-------运算符--------------关联性------
-      ()[]                 L
-       !~                  R
-      */%                  L
-      + -                  L
-      >> >>> <<            L
-      > >= < <=            L
-      == !=                L
-      &                    L
-      ^                    L
-      |                    L
-      &&                   L
-      ||                   L
-      = += -= /= *= %= >>= <<= &= ^= |=        R
-      ,(逗号运算符)          L              (例: println("a","b"))
从上到下优先级由高到低               
```

## Part35 程序流程控制
```
    同Java,分为三大类:
    顺序控制: 从上到下逐行执行, 中间没有任何判断和跳转
    分支控制: 
        单分支: if
        双分支: if else
        多分支: if ... else if ... else / switch case
        分支控制的注意事项: 如果大括号{}内的逻辑代码只有一行, 大括号可以省略, 同Java
        Scala中任意表达式都有返回值的, 也就意味着if else表达式其实是由返回结果的, 具体返回结果的值取决于满足条件的代码体的最后一行内容
    循环控制
    
    理论上, 嵌套分支不要超过三层
    
    switch-case 分支结构, 涉及模式匹配 
    
    for循环控制 / for推导式
    for (i <- start to end) {}
    i表示循环的变量, i将会从start到end循环, 前后闭合
    
    循环守卫, 即循环保护式(也称为条件判断式, 守卫), 保护式为true则进入循环体内部, 为false则跳过, 类似continue
    
    until 前闭合后开区间的范围,
    for (i <- start until end) {}
    
    while(condition){循环体}
    
    do {循环体} while(condition)
    
    多层循环, 将一个循环放在另一个循环体内
    
    while循环的中断: Scala内置控制结构特地去掉了break和continue, 是为了更好的适应函数化编程, 推荐使用函数式编程
    break() 函数
    breakable() 函数是一个高阶函数, 可以接收函数的函数就是高阶函数
    也可以使用if-else或者循环守卫实现continue的效果
    
    
```

## 函数式编程
```
函数式编程的基础:
常见概念说明:
1,在Scala中,方法和函数几乎可以等同,只是函数的使用方式更加的灵活多样[方法转函数]
2,函数式编程时从编程方式(范式)的角度来谈的, 可以这样理解: 函数式编程把函数当作一等公民, 充分利用函数,支持的函数的多种使用方式
  在Scala中, 函数是一等公民,想变量一样,既可以作为函数的参数使用,也可以将函数赋值给一个变量, 函数的创建不用依赖于类或者对象, 而在Java当中, 函数的闯进啊则要依赖于类,抽象类或者接口
3,面向对象编程是以对象为基础的编程方式
4,在Scala中函数式编程和面向对象编程融合在一起

函数定义/声明
  def 函数名([参数名: 参数类型], ...)[:返回值类型] = {
    语句
    return 语句
  }
  1,函数声明关键字为def
  2,[参数名:参数类型],... 表示函数的输入,可以没有, 如果有,多个参数使用逗号隔开
  3,函数中的语句,表示为了实现某一功能代码块
  4,函数可以有返回值,也可以没有
  5,返回值形式1: :返回值类型 = 
  6,返回值形式2: = 表示返回值类型不确定, 使用类型推导完成
  7,返回值形式3:  空表示没有返回值, return不生效
  8,如果没有return, 默认以执行到最后一行的结果作为返回值
  
  函数的注意事项:
    1),函数的形参列表可以是多个, 如果函数没有形参, 调用时可以不带()
    2),形参列表和返回值列表的数据类型可以是值类型和引用类型
    3),Scala中的函数可以根据函数体最后一行代码自行推断返回值类型,
    4),因为Scala可以自行推断, 所以在省略return关键字的场合, 返回值类型也可以省略
    5),如果函数明确使用return关键字,那么函数返回就不能使用自行推断了,这时要明确写成":返回值类型=",
       当然如果你什么都不写, 说明不需要返回值, 即使有return, 那么返回值也为()
    6),如果函数明确无返回值(声明Unit), 那么函数体中即使使用return关键字,也不会有返回值
    7),如果明确函数无返回值或不确定返回值类型, 那么返回值类型可以省略(或者声明为Any)
    8),Scala语法中任何的语法结构都可以嵌套其他语法结构, 即: 函数中可以再声明/定义函数, 
       类中可以再声明类, 方法中可以再声明/定义方法
    9),Scala函数的形参, 在声明参数时, 直接赋值初始值(默认值), 这时调用函数时,如果没有指定实参, 则会使用默认值.
       如果指定了实参,则实参会覆盖默认值.
    10),如果函数存在多个参数, 每个参数都可以设定默认值, 那么这个时候传递的参数到底是覆盖默认值, 还是赋值给没有默认值的参数,
       就不确定了(默认按照声明顺序[从左到右]),在这种情况下,可以采用带实名参数
    11), Scala函数的形参默认是val的, 因此不能再此函数中进行修改
    12),递归函数未执行之前是无法推断出结果类型的, 在使用时必须有明确的返回值类型
    13),Scala函数支持可变参数, 可变参数需要写在形参的最后, args是集合,通过for循环可以访问到各个值
函数运行机制
  函数的调用机制:类似Java
递归[推荐使用递归来解决问题]
  每调用一次函数,在内存中就会开辟一个栈空间
  
  函数递归需要遵守的重要原则:
  1,执行一个函数时, 就创建一个新的受到保护的独立空间(新函数栈)
  2,函数的局部变量是独立的, 不会相互影响
  3,递归必须向退出递归的条件逼近, 否则就是无限递归
  4,当一个函数执行完毕, 或者遇到return,就会返回, 遵守谁调用就将结果返回给谁
  
过程(过程就是一个概念)
  将函数的返回类型为Unit的函数称之为过程(procedure), 如果明确函数没有返回值, 那么等号可以省略
  
  注意: 如果函数声明时没有返回值类型, 但是有=号, 可以进行类型推断最后一行代码.
       这时这个函数实际是有返回值的, 该函数并不是过程.
  
惰性函数
  惰性计算(尽可能延迟表达式求值)是许多函数式编程语言的特性,惰性集合再需要时提供其元素,无需预先计算他们,
  这带来了一些好处, 首先,您可以将耗时得计算推迟到绝对需要得时候, 其次,您可以创造无限个集合, 只要他们继续收到请求,就会继续提供元素
  函数得惰性使用让您能够得到更高效得代码, Java并没有为惰性提供原生支持,Scala提供了.
  
  当函数返回值被声明为lazy时, 函数的执行将被推迟, 直到我们首次对此取值, 该函数才会执行.
  这种函数我们称之为惰性函数, 在Java的某些框架代码中称之为懒加载(延迟加载)
  
  注意:
  lazy 不能修饰var类型变量
  不但是在调用函数时, 加了lazy,会导致函数的执行被退出, 我们在声明一个变量时, 如果给声明了lazy, 那么变量值得分配也会推迟
  
异常
  1,Scala提供try和catch块来处理异常. try块用于包含可能出错得代码. 
    catch块用于处理try块中发生得异常. 可以根据需要在程序中有任意数量得try...catch块
  2,语法处理上和Java类似, 但是又不尽相同
  3,在Scala中只有一个catch, 可以有多个case, 每个case可以匹配一种异常case ex: xxx
    => 关键符号,表示后面是要对异常的处理代码块
    finally 最终要执行的
  
  小结:
    1),将可疑代码封装在try块中, 使用catch处理程序来捕获异常,发生异常时,catch处理厂程序将处理它, 程序将不会异常终止
    2),Scala的异常工作机制和Java一样,但是Scala没有"checked(编译器)"异常,所有异常都在运行时去捕获处理
    3),用throw关键字,抛出一个异常对象.所有异常都是Throwable的子类型, throw表达式是有类型的, 就是Nothing
       因为Nothing是所有类型的子类型, 所以throw表达式可以用在需要类型的地方
    4),在Scala中, 借助模式匹配的思想来做异常的匹配, 因此,在catch的代码里, 是一系列case子句来匹配异常
    5),越具体的异常越靠前, 越普遍的异常越靠后
    6),finally子句用于执行不管是正常处理还是有异常发生时都需要执行的步骤, 一般用于清理工作
    7),Scala中提供了throws关键字来声明异常
    
    
面向对象编程:
  Java是面向对象的编程语言, Java中还存在着非面向对象的内容, 基本类型, null, 静态方法
  Scala语言来自于Java, 所以天生就是面向对象的语言, 而且Scala是纯粹的面向对象语言, 即在Scala中一切皆对象
  在面向对象的学习过程中可以对比着Java语言学习
  
  类和对象的区别和联系
  1),类是抽象的, 概念的,代表一类事物,
  2),对象是具体的, 实际的,代表一个具体事物
  3),类是对象的模板,对象是类的一个个体, 对应一个实例
  4),scala中类和对象的区别和联系和Java是一样的
  
  [修饰符]class 类名 {
    类体
  }
  定义类的注意事项:
  1),Scala语法中, 类并不声明为public, 所有这些类都具有共有可见性(即默认就是public)
  2),一个Scala源文件可以包含多个类
  3),属性是类的一个组成部分,一般是值数据类型, 也可是引用类型
  定义属性的注意事项:
  1),属性的定义语法同变量, [访问修饰符]var 属性名称[:类型] = 属性值
  2),属性的定义类型可以为任意类型, 包含值类型或引用类型
  3),Scala中声明一个属性, 必须显示的初始化, 然后根据初始化数据的类型自动推断, 属性类型可以省略
  4),如果赋值为null, 则一定要加类型, 因为不加类型, 那么该属性的类型就是Null类型
  5),如果在定义属性是, 暂时不赋值, 也可以使用符号_(下划线), 让系统分配默认值
       类型                   _对应的值
       Byte,Short,Int,Long      0
       Float, Double            0.0
       String和引用类型           null
       Boolean                  false
  6),不同对象的属性是相互独立的, 互不影响,一个对象对属性的更改,不影响另一个
    
  属性的高级部分
  说明: 属性的高级部分和构造器(构造方法/函数)相关, 
   
   创建对象基本语法:
   val | var 对象名[: 类型] = new 类型()
   说明:
      1),如果我们不喜欢改变对象的引用(即内存地址), 应该声明为val性质的, 否则声明为var,
        Scala设计者推荐使用val, 因为一般来说, 在程序中, 我们呢只改变对象属性的值, 而不是改变对象的引用
      2),Scala在声明对象变量时,可以根据创建对象的类型自动推断, 所有类型声明可以省略, 但当类型和后面new对象类型有继承关系即多态时,
        就必须写类型
   
   方法
   Scala中的方法其实就是函数, 声明对照请参考函数式编程中的函数声明
   基本语法:
   def 方法名(参数列表)[: 返回值类型] = {
        方法体
   }
   方法的调用机制: 程序调用方法过程 +　说明
   1), 当我们Scala开始执行时, 先在栈区开辟一个main栈, mainzh栈是最后销毁
   2),当Scala程序在执行到一个方法时, 总会开一个新的栈
   3),每个栈是独立的空间, 变量(基本数据类型)是独立的, 互不影响
   4),当方法执行完毕后, 该方法开辟的栈就会被JVM回收
   
   构造器
   Scala构造器的介绍
   和Java一样,Scala构造对象也需要调用构造方法, 并且可以有任意多个构造方法(也支持重载)
   Scala类的构造器包括: 主构造器和辅助构造器
   
   Scala构造器的基本语法
   class 类名(形参列表) {     // 主构造器只有一个
        // 类体
        def this(形式参数1) {    // 辅助构造器
            
        }
        def this(形式参数2) {    // 辅助构造器可以有多个
                    
        }
   }
   辅助构造器函数的名称this, 可以有多个, 编译器通过不同参数来区分
   构造器的注意事项和细节:
   1),Scala构造器作用是完成对新对象的初始化, 构造器没有返回值
   2),主构造器的声明直接放置于类名之后
   3),主构造器会执行定义中的所有语句, 这里可以体会到Scala的函数式编程和面向对象编程融合在一起, 即:构造器也是方法(函数), 传递参数和使用方法和函数没有区别
   4),如果主构造器无参数, 小括号可以省略
   5),辅助构造器名称是this, 多个辅助构造器通过不同参数列表进行区别
   6),如果想让主构造器为私有的, 可以在()之前加上private, 这样用户只能通过辅助构造器来构造对象了
   7), 辅助构造器的声明不能和主构造器的声明一致, 会发生错误
   
   属性的高级部分
   属性的高级部分和构造器(构造器,构造方法)相关, 
   1),Scala类的主构造器的形参未用任何修饰符修饰, 那么这个参数是局部变量
   2),如果参数使用val关键字声明, 那么Scala会将参数作为类的私有的只读属性
   3),如果参数使用var关键字声明, 那么Scala会将参数作为类的成员属性使用, 并会提供属性对应的xx()[类似getter]/xx_$eq()[类似setter]方法, 即这时的成员属性是私有的, 但是可读写
   
   Bean属性
   JavaBean规范定义了Java的属性是像getXx()和setXx()方法, 将Scala字段加@BeanProperty时, 这样会自动生成规范的setXx/getXx方法,可以使用对象的getXx方法和setXx方法来调用属性
   注意: 给属性添加了@BeanProperty注解,会生成getXx和setXx方法, 并且对原来底层自动生成类似xxx(),xxx_$eq()方法,没有冲突,二者可以并存
   
   包
   Scala包的基本介绍:
   和Java一样, Scala中管理项目可以使用包, 但Scala中的包的功能更加强大,使用也相对复杂
   基本语法
   package 包名
   
   Scala包的三大作用(和Java一样)
   1),区分相同名字的类
   2),当类很多时, 可以很好的管理类
   3),控制访问范围
   4),可以对类的功能进行扩展
   
   Scala中包名和源码所在的系统文件目录可以不一致,但是编译后的字节码文件路径和包名会保持一致
   
   Scala包的命名方式
   只能包含数字,字母,下划线,小圆点. ,但不能以数字开头,也不能使用关键字
   命名规范:一般是小写字母+小圆点, 例如: com.公司名称.项目名称.业务模块名称
   Scala会自动引入的常用包
   java.lang.*
   scala包
   Predef包
   
   Scala包的注意事项和使用细节
   1),Scala进行package打包时, 可以有如下形式:
   查看PackageMth
   2),包也可以像嵌套类那样使用(包种有包), 这个在使用第三种方式时的好处是:程序员可以在同一个文件中将类(class/object),trait创建在不同的包中,这样很灵活
   3),作用域原则: 可以直接向上访问, 即Scala种子包种直接访问父包种中的内容,大括号体现作用域, 在子包和父包类重名时, 采用就近原则,如果希望指定使用某个类,则带上包名即可
   4),父包要访问子包的内容时,需要import对应的类
   5),可以在同一个.scala文件中,声明多个并列的package(建议嵌套的package不要超过3层)
   6),包名可以相对路径也可以绝对路径,比如访问BeanProperty的绝对路径是:
      _root_.scala.beans.BeanProperty,在一般情况下, 我们使用相对路径来引入包, 只有当包名称冲突时,才使用绝对路径
   
   包对象
   基本介绍: 包可以包含类, 对象和特质trait, 但不能包含函数/方法或变量的定义, 这是Java虚拟机的局限, 为了弥补这一点,Scala提供了包对象的概念来解决这个问题
   查看PackageMth中的包对象部分
   包对象的注意事项:
   包对象和子包是一个平级的关系,
   包对象的名称和子包的名称一致, 一般用来对包的功能补充
   
   包的可见性
   Java提供了四种访问控制修饰符号控制方法和变量的访问权限(范围):
   1),公开级别: 用public修饰, 对外公开
   2),受保护级别,用protected修饰,对子类和同一个包中的类公开
   3),默认级别, 没有修饰符号,向同一个包中的累公开
   4),私有级别,用private修饰,只有类本身可以访问,不对外公开
   Scala包的可见性
   在Scala中同样可以通过类似Java的修饰符达到同样的效果
   
   Scala的设计者将static关键字取消了, 他认为static不是真正的面向对象, 他就设计了伴生类和伴生对象的概念来替代static
   伴生类 写静态的内容, 伴生对象 写静态内容, 在伴生对象中可以访问伴生类中的属性及私有属性
   
   Scala中包的可见性和访问修饰符的使用
   1,当属性访问权限为默认时, 从底层看属性是private的,但是因为提供了xxx_$eq()类似[setter] / xxx()类似[getter]方法, 因此从使用效果来看是任何地方可以访问的
   2,当方法访问权限为默认时,默认为public访问权限
   3,private为私有权限,只在类的内部和伴生对象中可用
   4,protected为受保护权限,Scala中受保护权限比Java中更严格,只能子类访问,同包无法访问
   5,在Scala中没有public关键字,即不能用public显式的修饰属性和方法
   6,包访问权限(表示属性有了限制,同时包也有了限制), 这点和Java不一样, 体现了Scala包使用的灵活性
   
   包的引入
   Scala包的引入基本介绍
   Scala引入包也是使用import关键字,基本原理和机制同Java, 但是Scala中的import更加强大,也更灵活
   因为Scala语言原子Java,所以Java.lang包中的类会自动引入到当前环境中, 而Scala中的Scala包和Predef包的类也会自动引入到当前环境中, 随即其下的类可以直接使用
   如果想要把其他包中的类引入到当前环境中, 需要使用import语句
   Scala引入包的细节和注意事项
   1,在Scala中,import语句可以出现在任何地方,并不仅限于文件顶部,import语句的作用一致延伸到包含该语句的末尾, 这种语法的好处是:在需要时才引入包, 缩小import包的作用范围,提高效率
   2,Java中如果想要导入包中所有的类, 可以使用通配符*, Scala中采用下划线_
   3,如果只想引入某个包下的部分类,可以使用选择器{类名称},选择引入包的指定类,
   4,如果引入的多个包中含有相同的类, 那么可以将不需要的类进行重命名来区分{类名称 => 新名称}
   5,如果某个冲突的类根本不会用到, 那么这个类可以直接隐藏掉{类名称 => _, _} , 第一个_表示忽略掉的类名称, 第二个下划线_表示引入所有
   
   面向对象编程的三大特性
   封装:把抽象出来的数据和对数据的操作封装在一起, 数据被保护在内部, 程序的其他部分只有通过被授权的操作(成员方法), 才能对数据进行操作
       封装的好处:
       1,隐藏实现细节, 2,加入数据验证,保证安全合理, 3,同时可以加入逻辑
       如何体现封装:
       1,对类中的属性进行封装, 2,通过成员方法,包实现封装
       封装的步骤:
       1,对属性进行私有化
       2,提供一个公共的set方法, 用于对数学判断并赋值
         def setXX(参数名称; 类型):Unit = {
            // set中可以加入逻辑
            属性 = 参数名
         }
       3,提供一个公共的get方法, 用于获取属性的值
         def getXX()[:返回类型] = {
            return 属性
         }
   继承: 
   多态:
   面向对象编程方法- 抽象
   在定义一个类的时候就是把一个事物的公共属性和行为提取出来,形成一个物理模型(模板), 这种研究问题的方法叫做抽象
   
   
   
   
   
函数式编程高级:

值函数(函数字面量)
高阶函数
闭包
应用函数
柯里化函数, 抽象控制



```


### 快捷键  shortcut key
```text
格式化文档:
1 - ctrl + alt + l  格式化代码
2 - ctrl + b 进入光标所在类或者查看包下的所有子类
```

### REPL常用命令
```text
:q  -  退出Scala REPL

```
### 学习的套路
```
学一个技术或知识点的流程:
1,需求(遇到问题): 
2,解决思路(用传统的方法可以解决但是不够完美, 真解决不了的时候,用新技术)
3,学习新技术的基本语法和基本运行原理
4,编写快速入门案例(哪怕很简单也好)
5,反复琢磨该技术的使用细节,使用陷阱, 如何使用规范和高效(这里就体现了编程水平)
```
```text



```
