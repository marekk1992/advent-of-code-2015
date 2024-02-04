package code.advent.day8

import scala.io.Source

object Task8 extends App {

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_8_input.txt")

  val result = (for {
    line <- bufferedSource.getLines()
    increasedStringLength = getIncreasedStringLength(line)
  } yield increasedStringLength - line.length).sum

  println(result)

  private def getIncreasedStringLength(input: String): Int = {
    val withStringBeginningResolved = input.headOption.map(_ => 111 + input.tail).get
    val withStringEndResolved = withStringBeginningResolved.init + 111
    withStringEndResolved
      .replaceAll("\\\\\"", "1111")
      .replaceAll("\\\\", "11")
      .length
  }
}
