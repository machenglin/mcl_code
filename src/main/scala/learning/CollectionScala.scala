/**
  * Created by Mcl on 2017/12/20.
  */
object CollectionScala {

  def main(args: Array[String]) {
    // 定义整形List
    val list = List[Int](1, 2, 3, 4)
    println(list)
    // head 返回第一个参数
    // tail 返回一个列表，包含出第一元素之外的其他列表
    // isEmpty 在列表示为空时候返回true
    println(list.head)
    println(list.tail)
    println(list.isEmpty)
    // 空列表
    val emptyList = List()

    // 二维列表
    val dim = List(
      List(1, 0, 0),
      List(0, 1, 0),
      List(0, 0, 1)
    )

    // 构建列表的两个基本单位是Nil和 ::
    // Nil也可以表示一个空列表
    val book = "java" :: ("scala" :: Nil)
    // 连接列表
    val multiList1 = book ::: list
    val multiList2 = book.:::(list)
    val multiList3 = List.concat(book, list)
    println(multiList3)

    // Lists.fill() 创建一个指定重复数量的元素列表
    val site = List.fill(3)("小骷髅")
    println(site)

    // Lists.tabulate()通过给定的函数来创建列表
    val squares = List.tabulate(5)(n=>n*n)
    println("一维:" + squares)
    var mul =List.tabulate(5,5)(_*_)
    println("多维:" + mul)

    // List.reverse
    println(list.reverse)

    // 定义Set
    val set = Set(1, 3, 5, 7)

    // 定义map
    val map = Map(1 -> "小林", 2 -> "小米")

    // 创建两个不同类型元素的元组
    val x = (10, "Scala")

    // 迭代器
    var it = Iterator(1,2,34)
    /*println(it.min)
    println(it.max)
    while (it.hasNext){
      println(it.next())
    }*/
    println(it.length)
  }

}
