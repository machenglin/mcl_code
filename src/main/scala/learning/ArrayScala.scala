/**
  * Created by Mcl on 2017/12/20.
  */
object ArrayScala {

  def main(args: Array[String]) {
    val arr = new Array[String](3);
    arr(0) = "a"
    arr(1) = "b"
    arr(2) = "c"

    for (x <- arr) {
      println(x)
    }
    val myList = Array(1.9, 2.9, 3.4, 3.5)
    var total = 0
    for (x <- myList) {
      println(x)
      total += x.toInt
    }
    println("sum = " + total)

    // 多维数组
    import Array._
    val myMatrix = ofDim[Int](3, 3)

    // 创建矩阵
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        myMatrix(i)(j) = j
      }
    }

    // 打印二维阵列
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        print(" " + myMatrix(i)(j))
      }
      println()
    }
  }
}
