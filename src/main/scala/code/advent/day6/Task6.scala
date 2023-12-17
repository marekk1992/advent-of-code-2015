package code.advent.day6

import scala.io.Source

object Task6 extends App {

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_6_input.txt")
  private val grid: Array[Array[Int]] = Array.ofDim[Int](1000, 1000).map(_ => Array.fill(1000)(0))

  for {
    line <- bufferedSource.getLines()
    function = line.takeWhile(!_.isDigit).trim
    coordinateOne = line.drop(function.length).takeWhile(!_.equals('t')).trim.split(",").map(_.toInt)
    coordinateTwo = line.substring(line.indexOf("through")).replace("through", "").trim.split(",").map(_.toInt)
    rowRange = coordinateOne(0) to coordinateTwo(0)
    columnRange = coordinateOne(1) to coordinateTwo(1)
  } processGrid(function, rowRange, columnRange)

  private def processGrid(function: String, rowRange: Range, columnRange: Range): Unit = {
    function match {
      case "turn on" => for {
        row <- rowRange
        column <- columnRange
      } grid(row)(column) = grid(row)(column) + 1
      case "turn off" => for {
        row <- rowRange
        column <- columnRange
      } grid(row)(column) = if (grid(row)(column) == 0) 0 else grid(row)(column) - 1
      case "toggle" => for {
        row <- rowRange
        column <- columnRange
      } grid(row)(column) = grid(row)(column) + 2
    }
  }

  val result = grid.flatten.sum

  println(result)
}
