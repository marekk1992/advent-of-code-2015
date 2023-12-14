package code.advent.day5

import scala.io.Source

object Task5 extends App {

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_5_input.txt")

  val input = bufferedSource.getLines().toList
  val result = input.count(isNiceString)

  println(result)

  def isNiceString(input: String): Boolean = {
    input.sliding(2, 1).exists(pair => input.replaceFirst(pair, ".").contains(pair)) &&
      input.sliding(3, 1).exists(pair => pair(0) == pair(2))
  }
}
