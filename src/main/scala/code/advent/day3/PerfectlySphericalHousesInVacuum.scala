package code.advent.day3

import scala.annotation.tailrec
import scala.io.Source

object PerfectlySphericalHousesInVacuum extends App {

  val NORTH = '^'
  val SOUTH = 'v'
  val EAST = '>'
  val WEST = '<'

  case class Coordinate(x: Int, y: Int)

  private val bufferedSource = Source.fromFile("src/main/resources/inputs/adventofcode.com_2015_day_3_input.txt")

  val input: List[Char] = bufferedSource.getLines().flatten.toList
  val coordinatesMap = findAllVisitedLocations(input, Coordinate(0, 0), Set(Coordinate(0, 0)))
  val result = coordinatesMap.size
  println(result)

  bufferedSource.close()

  @tailrec
  private def findAllVisitedLocations(input: List[Char], lastCoordinate: Coordinate, coordinates: Set[Coordinate]): Set[Coordinate] = {
    if (input.isEmpty) coordinates
    else {
      val currentCoordinate = input.head match {
        case NORTH => Coordinate(lastCoordinate.x, lastCoordinate.y + 1)
        case SOUTH => Coordinate(lastCoordinate.x, lastCoordinate.y - 1)
        case EAST => Coordinate(lastCoordinate.x + 1, lastCoordinate.y)
        case WEST => Coordinate(lastCoordinate.x - 1, lastCoordinate.y)
      }
      findAllVisitedLocations(input.drop(1), currentCoordinate, coordinates + currentCoordinate)
    }
  }
}
