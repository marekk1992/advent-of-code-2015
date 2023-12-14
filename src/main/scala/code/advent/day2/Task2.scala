package code.advent.day2

import scala.io.Source

object Task2 extends App {

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_2_input.txt")

  val result = (for {
    rectangle <- bufferedSource.getLines().map(inputLine => Rectangle(inputLine)).toList
  smallestPaperArea = rectangle.calculateRibbonAmount()
  } yield smallestPaperArea).sum

  println(result)

  bufferedSource.close

  class Rectangle(length: Int, width: Int, height: Int) {
    private val dimensions = List(length, width, height)

    def calculateRibbonAmount(): Int = {
      val bowArea = length * width * height
      val presentArea = dimensions.sorted.take(2).map(_*2).sum
      bowArea + presentArea
    }
  }

  private object Rectangle {
    def apply(input: String): Rectangle = {
      val dimensions = input.split('x')
      new Rectangle(dimensions(0).toInt, dimensions(1).toInt, dimensions(2).toInt)
    }
  }
}
