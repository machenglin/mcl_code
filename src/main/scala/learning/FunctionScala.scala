/**
  * Created by Mcl on 2017/12/20.
  */
object FunctionScala {
  def main(args: Array[String]) {
    delayed(time())
    // 可变参数
    printStrings("金凯", "小米")
    // 递归函数
    for (i <- 1 to 5) {
      println(i + "！=" + factorial(i))
    }
    // 默认参数值
    println("默认求和值：" + addInt())
    // 高阶函数：就是操作其他函数的函数
    println(layout[String]("a"))
    println(apply(layout, 10))
    // 匿名函数：箭头左边是参数列表，右边是函数体
    var inc = (x:Int) => x+1



  }

  def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime()
  }

  def delayed(t: Long) = {
    println("在delayed方法内")
    println("参数：" + t)
    t
  }

  def printStrings(strs: String*) {
    var i: Int = 0
    for (str <- strs) {
      println("strs[" + (i) + "]=" + str)
      i += 1
    }
  }

  def factorial(n: BigInt): BigInt = {
    if (n <= 1) {
      return 1
    }
    n * factorial(n - 1)
  }

  def addInt(a: Int = 5, b: Int = 7): Int = {
    var sum = 0
    sum = a + b
    sum
  }

  def layout[A](x: A) = "[" + x.toString + "]"

  def apply(f: Int => String, v: Int) = f(v)
}


