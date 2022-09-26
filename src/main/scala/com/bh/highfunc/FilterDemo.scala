package com.bh.highfunc

/**
 * filter:过滤出符合一定条件的元素，示例，筛选偶数：
 */
object FilterDemo {
  def main(args: Array[String]): Unit = {
    val list = (1 to 6).toList
    println(list.filter(_ % 2 == 0))//List(2, 4, 6)
  }

}
