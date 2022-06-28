package com.bh.highfunc

object SortDemo {
  def main(args: Array[String]): Unit = {
    //升序排序
    val list = List(3, 1, 2, 9, 8)
    println(list.sorted)//List(1, 2, 3, 8, 9)
    //指定字段排序
    val list2 = List("01 hadoop", "02 flume", "03 hive")
    println(list2.sortBy(_.split(" ")(1)))//List(02 flume, 01 hadoop, 03 hive)
    //自定义排序实现降序
    val list3 = List(2, 3, 1, 6, 4, 5)
    //第一个下划线表示前面的元素，第二个下划线表示后面的元素
    println(list3.sortWith(_ > _))//List(6, 5, 4, 3, 2, 1)
  }

}
