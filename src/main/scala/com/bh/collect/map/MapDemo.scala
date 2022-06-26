package com.bh.collect.map

object MapDemo {
  def main(args: Array[String]): Unit = {
    var seq = Seq(1,2,3)
    //  map之后(id, seq)表示构造一个元组。 Seq(1L, 2L, 3L).map(id => (id, seq)) 的返回值类型是Seq[(Long, Seq[Int])]
    val value = Seq(1L, 2L, 3L).map(id => (id, seq)).partition(_._2.nonEmpty)
    var person =Map("bh" ->19)
    person += ("wf" ->20)
    println(person)

    var hobby =Map("aa" ->"it")

    val keys = person.keys
    keys.foreach(println(_))
    println(keys)
    val values = person.values
    println(values)

    //合并Map
    val mergeMap = person ++ hobby
    //Map(bh -> 19, wf -> 20, aa -> it)
    println(mergeMap)

  }

}
