/**
  * Created by Mcl on 2017/12/20.
  */

object RegexScala{
  def main(args: Array[String]) {
    // .r 构造一个Regex对象
    val pattern = "Scala".r
    val str = "Scala is Scalable and cool"
    println( pattern findFirstIn str)
  }
}