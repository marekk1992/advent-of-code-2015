package code.advent.day6

import scala.io.Source

object Task6 extends App {

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_6_input.txt")
  val grid: Array[Array[String]] = Array.ofDim[String](1000, 1000).map(_ => Array.fill(1000)("OFF"))

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
      } grid(row)(column) = "ON"
      case "turn off" => for {
        row <- rowRange
        column <- columnRange
      } grid(row)(column) = "OFF"
      case "toggle" => for {
        row <- rowRange
        column <- columnRange
      } grid(row)(column) match {
        case "ON" => grid(row)(column) = "OFF"
        case "OFF" => grid(row)(column) = "ON"
      }
    }
  }

  val result = grid.flatten.count(_.equals("ON"))

  println(result)
}
