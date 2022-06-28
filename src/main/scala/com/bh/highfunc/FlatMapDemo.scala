package com.bh.highfunc

/**
 * 可以理解为先进行 map ，再进行 flatten 操作。
 */
object FlatMapDemo {
  def main(args: Array[String]): Unit = {
    val list = List("hadoop hive spark flink", "kudu hbase storm")

    val list2 =list.map(_.split(" ")).flatten
    println(list2)//List(hadoop, hive, spark, flink, kudu, hbase, storm)

    val list3 =list.flatMap(_.split(" "))
    println(list2)//List(hadoop, hive, spark, flink, kudu, hbase, storm)
  }

}
