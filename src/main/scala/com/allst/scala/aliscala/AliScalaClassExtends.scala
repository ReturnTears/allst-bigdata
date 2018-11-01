package com.allst.scala.aliscala

/**
  * @author June on 2018-06-14
  *         继承与组合
  *         构造函数执行顺序
  *         方法重写
  *         匿名类
  *         多态与动态绑定
  */
object AliScalaClassExtends {

  def main(args: Array[String]): Unit = {
    /**
      * 执行下面语句会依次打印父类、子类语句
      * 说明：在构造子类之前会先调用父类的主构造方法
      */
    val stu = new Students("Uy", 18, 101)
    //stu.wakeup()

    val tea = new Teacher("June", 18, "1024")
    //tea.walk()

    // 定义一个匿名类
    val s = new Perple("July", 22) {
      override def walk(): Unit = {
        println("walk like a normal perple")
      }

      def talkTo(p: Perple): Unit = {
        println("oooooo")
      }
    }
    s.walk()
  }

  // Personal类
  class Personal(name: String, age: Int) {
    //println("Construct Personal")
    def wakeup(): Unit = println(name + " today wakeup on time")
  }
  // Students类
  class Students(name: String, age: Int, stuNo: Int) extends Personal(name, age) {
    //println("Construct Students")
    override def wakeup(): Unit = {
      // 调用父类的wakeup方法
      super.wakeup()
      // 增加了自己的实现
      println(name + " child extends father add realize")
    }
  }

  /**
    * 继承代码等同于下面的Java代码
    * //Person类
    class Personal{
      private String name;
      private int age;
      public Person(String name,int age){
         this.name=name;
         this.age=age;
        System.out.println("Construct Personal");
      }
    }

    //Student继承Person类
    class Students extends Personal{
        private String studentNo;
        public Student(string name,int age,String studentNo){
            super(name,age);
            this.sutdentNo=studentNo;
        System.out.println("Construct Students");
        }
    }
    */

  // 定义抽象的Perple类
  abstract class Perple(name: String, age: Int) {
    def walk(): Unit
    // talkTo方法,参数为Perple类型,多态用
    def talkTo(p: Perple): Unit
  }

  class Teacher(name: String, age: Int, var teachNo: String) extends Perple(name, age) {
    // 重写抽象类中的walk方法，可以不加关键字override
    def walk(): Unit = {
      println("walk like a elegant swan")
    }
    //  重写父类的方法
    def talkTo(p: Perple): Unit = {
      println("talkTo method in Teacher")
      println(this.name + " is talking to " )
    }
  }


}
