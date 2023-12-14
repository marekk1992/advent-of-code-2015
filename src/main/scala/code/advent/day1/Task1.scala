package code.advent.day1

import scala.annotation.tailrec
import scala.io.Source

object Task1 extends App {

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_1_input.txt")
  private val input = bufferedSource.getLines().mkString.zipWithIndex.map( { case (char, index) => index + 1 -> char }).toList

  private val result = iterateFloors(0, 1, input)
  println(result)

  bufferedSource.close

  @tailrec
  private def iterateFloors(acc: Int, currentFloorIndex: Int, input: List[(Int, Char)]): Int = {
    if (acc < 0) currentFloorIndex
    else {
      val currentFloor = input.head
      val floor = if (currentFloor._2 == '(') 1 else -1
      iterateFloors(acc + floor, currentFloor._1, input.drop(1))
    }
  }
}
