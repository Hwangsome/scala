package com.bh.highfunc

/**
 * map:将一种类型转换为另一种类型，例如将 Int 列表转为 String 列表
 */
object MapDemo {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    //将数字转换为对应个数的 *
    val list2 = list.map((x:Int) => {"*" * x})
    println(list2)//List(*, **, ***, ****)
    //根据类型推断简化
    val list3 = list.map(x => "*" * x)
    println(list3)//List(*, **, ***, ****)
    //下划线
    val list4 = list.map("*" * _)
    println(list4)//List(*, **, ***, ****)
  }

}
