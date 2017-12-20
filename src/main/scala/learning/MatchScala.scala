/**
  * Created by Mcl on 2017/12/20.
  */
object Test {
  def main(args: Array[String]) {
    println(matchTest(2))
    println(matchTest02("two"))
    println(matchTest02("test"))
    println(matchTest02(1))
    println(matchTest02(6))
  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
  }

  def matchTest02(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scaka.Int"
    case _ => "many"
  }

}
