package com.bh.highfunc

object GroupByDemo {
  def main(args: Array[String]): Unit = {
    val list = List("sjh"->"男","ssf"->"女","ka"->"男")
    //按照元素第二个元素分组
    //val map = list.groupBy(x => x._2)
    val map = list.groupBy(_._2)
    println(map)//Map(男 -> List((sjh,男), (ka,男)), 女 -> List((ssf,女)))
    //统计不同性别人数
    val map2 = map.map(x => x._1 -> x._2.length)//不能用下划线简化，因为x在后面出现了2次
    println(map2)//Map(男 -> 2, 女 -> 1)
  }

}
