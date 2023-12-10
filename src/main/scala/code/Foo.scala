package code

object Foo extends App {

  val list = List(4, 9, 7, 6)
  val splitter = list.length / 2

  val secondList = list.grouped(splitter).toList.last

  println(secondList)

}
