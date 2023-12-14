package code.advent.day3

import scala.annotation.tailrec
import scala.io.Source

object Task3 extends App {

  private val NORTH = '^'
  private val SOUTH = 'v'
  private val EAST = '>'
  private val WEST = '<'

  private case class Coordinate(x: Int, y: Int)

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_3_input.txt")

  val input: List[Char] = bufferedSource.getLines().flatten.toList
  val result = findAllVisitedHouses(input)
  println(result)

  bufferedSource.close()

  private def findAllVisitedHouses(input: List[Char]): Int = {
    val santaLocations = input.zipWithIndex.filter( {case (_, index) => index % 2 == 0} ).map(_._1)
    val roboSantaLocations = input.zipWithIndex.filter( {case (_, index) => index % 2 != 0} ).map(_._1)

    val uniqueVisitedHouses = visitHouses(santaLocations, Coordinate(0, 0), Set(Coordinate(0, 0)))
      .union(visitHouses(roboSantaLocations, Coordinate(0, 0), Set(Coordinate(0, 0))))

    uniqueVisitedHouses.size
  }

  @tailrec
  private def visitHouses(input: List[Char], lastCoordinate: Coordinate, coordinates: Set[Coordinate]): Set[Coordinate] = {
    if (input.isEmpty) coordinates
    else {
      val currentCoordinate = input.head match {
        case NORTH => Coordinate(lastCoordinate.x, lastCoordinate.y + 1)
        case SOUTH => Coordinate(lastCoordinate.x, lastCoordinate.y - 1)
        case EAST => Coordinate(lastCoordinate.x + 1, lastCoordinate.y)
        case WEST => Coordinate(lastCoordinate.x - 1, lastCoordinate.y)
      }
      visitHouses(input.drop(1), currentCoordinate, coordinates + currentCoordinate)
    }
  }
}
