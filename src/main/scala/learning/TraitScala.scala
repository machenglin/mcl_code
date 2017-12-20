/**
  * Created by Mcl on 2017/12/20.
  */
trait Equal {
  def isEqual(x: Any): Boolean
}

class Point(xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc

  def isEqual(obj: Any) =
    obj.isInstanceOf[Point] &&
      obj.asInstanceOf[Point].x == x
}
