package learning

/**
  * Created by Mcl on 2017/12/20.
  */
object FirstScala {
  def main(args: Array[String]) {
    println("hello world!")

    // 常量
    val a = 100
    // 变量
    var name = "小林"
    println("name : " + name)
    // 作用域
    (new Supper).fun()

    // 函数
    printMe()
    println("sum : 1 + 2 = " + addInt(1,2))
  }

  class Sub extends Supper {
    fun()
  }

  class Supper {
    def fun() {
      println("fun")
    }
  }

  def printMe(): Unit = {
    println("hello scala!")
  }

  def addInt(a: Int, b: Int): Int = {
    var sum = 0
    sum = a + b
    return sum
  }


}