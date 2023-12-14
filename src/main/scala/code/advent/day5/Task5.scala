package code.advent.day5

import scala.io.Source

object Task5 extends App {

  val VOWELS = Seq('a', 'e', 'i', 'o', 'u')
  val RESERVED_STRINGS = Seq("ab", "cd", "pq", "xy")

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_5_input.txt")

  val input = bufferedSource.getLines().toList
  val result = input.count(isNiceString)

  println(result)

  def isNiceString(input: String): Boolean = {
    input.count(VOWELS.contains) >= 3 &&
      RESERVED_STRINGS.count(input.contains) == 0 &&
      input.sliding(2, 1).exists(pair => pair(0) == pair(1))
  }
}
