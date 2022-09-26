package com.bh.highfunc

/**
 * 可以理解为先进行 map ，再进行 flatten 操作。
 */
object FlatMapDemo {
  def main(args: Array[String]): Unit = {
    val list = List("hadoop hive spark flink", "kudu hbase storm")

    val value = list.map(_.split(" "))
    println(value)

    val result = "hadoop hive spark flink".split(" ")
    println("result =" + result)

    //    val list2 =list.map(_.split(" ")).flatten
    //    println(list2)//List(hadoop, hive, spark, flink, kudu, hbase, storm)

    val list3 = list.flatMap(_.split(" "))
    println("list3 =" + list3)
    //    println(list2)//List(hadoop, hive, spark, flink, kudu, hbase, storm)

    //    var h: ::[String] = null
    //
    //    new ::()

    val list5 = (1 to 10)
    val value1 = list5.collect(_ % 2 == 0)
    println(value1)
    val value2 = list5.filter(_ % 2 == 0)

    println(value2)

    val value3 = list5.collect {
      case x if x % 2 == 0 => x
    }
    println(value3)
    val tail = list5.tail
    println(tail)
    val head = list5.head
    println(head)



  }

}
