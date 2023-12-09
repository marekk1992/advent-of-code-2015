package code.advent.day2

import scala.io.Source

object IWasToldThereWouldBeNoMath extends App {

  case class Rectangle(length: Int, width: Int, height: Int)

  private object Rectangle {
    def createInstance(input: String): Rectangle = {
      val dimensions = input.split('x')
      Rectangle(dimensions(0).toInt, dimensions(1).toInt, dimensions(2).toInt)
    }

    def wrappingPaperArea(rectangle: Rectangle): Int = {
      val sides = Seq(
        rectangle.length * rectangle.height,
        rectangle.height * rectangle.width,
        rectangle.width * rectangle.length
      )
      sides.map(side => 2 * side).sum + sides.min
    }
  }

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_2_input.txt")

  val result = (for {
    rectangle <- bufferedSource.getLines().map(inputLine => Rectangle.createInstance(inputLine)).toList
    smallestPaperArea = Rectangle.wrappingPaperArea(rectangle)
  } yield smallestPaperArea).sum

  println(result)

  bufferedSource.close
}
