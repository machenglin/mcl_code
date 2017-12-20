import java.io.{FileNotFoundException, FileReader, IOException}

/**
  * Created by Mcl on 2017/12/20.
  */

object ExceptionScala{
  def main(args: Array[String]) {
    try {
      var file = new FileReader("input.txt")
    }catch {
      case ex : FileNotFoundException =>{
        println("miss file exception")
      }
      case ex : IOException =>{
        println("Io exception")
      }
    }

  }

}
