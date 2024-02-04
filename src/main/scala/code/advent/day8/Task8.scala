package code.advent.day8

import scala.io.Source

object Task8 extends App {

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_8_input.txt")

  val result = (for {
    line <- bufferedSource.getLines()
    stringLength = line.length
    charactersInMemory = resolveLine(line)
  } yield stringLength - charactersInMemory).sum

  println(result)

  private def resolveLine(input: String): Int = {
    input
      .substring(1, input.length - 1)
      .replaceAll("\\\\\"", "1")
      .replaceAll("\\\\x([a-fA-F0-9]{2})", "1")
      .replaceAll("\\\\\\\\", "1")
      .length
  }
}
