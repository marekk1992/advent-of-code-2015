package code.advent.day1

import scala.annotation.tailrec
import scala.io.Source

object NotQuiteLisp extends App {

  val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_1_input.txt")
  private val input: List[Char] = bufferedSource.getLines().flatten.toList

  private val result = iterateFloors(0, input)
  println(result)

  bufferedSource.close

  @tailrec
  private def iterateFloors(acc: Int, input: List[Char]): Int = {
    if (input.isEmpty) acc
    else {
      val floor = if (input.head == '(') 1 else -1
      iterateFloors(acc + floor, input.drop(1))
    }
  }
}
