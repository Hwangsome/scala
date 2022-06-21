package com.bh.type1

object TypeDemo {
  def main(args: Array[String]): Unit = {
    //说明了字符串、整型、布尔值和函数都是对象，这一点和其他对象一样：
    val list: List[Any] = List(
      "a string",
      732, // an integer
      'c', // a character
      true, // a boolean value
      //<function0> 0表示这个函数没有参数，有x个参数，就是<functionx>
      () => "an anonymous function returning a string"
    )
//    list.foreach(println)

    //类型转换
    val x: Long = 987654321
    val y: Float = x // 9.8765434E8 (note that some precision is lost in this case)
    println(s"y=${y}")
    val face: Char = '☺'
    val number: Int = face // 9786
    println(s"number=${number}")
  }
}
