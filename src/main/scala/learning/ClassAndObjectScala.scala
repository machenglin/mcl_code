package learning

/**
  * Created by Mcl on 2017/12/20.
  */
class ClassAndObjectScala {

}

class Point(xc: Int, yc: Int) {
  var x = xc
  var y = yc

  def move(dx: Int, dy: Int): Unit = {
    x += dx
    y += dy
    println("x:" + x)
    println("y:" + y)

  }
}

class Location( val xc:Int, val yc:Int, val zc:Int) extends Point(xc,yc){
  var z:Int = zc
  def move(dx: Int, dy: Int, dz :Int): Unit = {
    x += dx
    y += dy
    z += dz
    println("x:" + x)
    println("y:" + y)
    println("z:" + z)

  }
}

object Test {
  def main(args: Array[String]) {
    var point = new Point(10, 20)
    point.move(10,10)

    var location = new Location(10,10,10)
    location.move(10,10,10)
  }
}

class Person{
  var name = ""
  override def toString = getClass.getName+"[name=" + name +"]"
}

class Employee extends Person{
  var salary = 0.0
  override def toString = super.toString + "[salary=" + salary +"]"
}

object Text extends App{
  val fred = new Employee
  fred.name = "Fred"
  fred.salary = 5000
  println(fred)

}