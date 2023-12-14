package code.advent.day4

import java.security.MessageDigest
import scala.annotation.tailrec

object Task4 extends App {

  val INPUT = "iwrupvqb"

  val result = findLowestNumber(0, INPUT)
  println(result)

  @tailrec
  private def findLowestNumber(number: Int, input: String): Int = {
    if (startsWithFiveZeros(input + number)) number
    else findLowestNumber(number + 1, input)
  }

  def startsWithFiveZeros(input: String): Boolean = {
    val hexBytes = MessageDigest.getInstance("MD5").digest(input.getBytes)
    val hexString = hexBytes.map("%02x".format(_)).mkString

    hexString.take(6) == "000000"
  }
}
