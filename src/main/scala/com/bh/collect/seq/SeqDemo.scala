package com.bh.collect.seq

/**
 *
 */
object SeqDemo {
  def main(args: Array[String]): Unit = {
    var seq = Seq(1,2,3)

    /**
     * partition()方法：返回一个元组，元组的第一个元素是满足partition方法参数的。第二个是不满足的。
     * val tuple1 = List(1, 2, 3).partition(_ > 2)
     * tuple1:(List(3),List(1, 2))
     * partion返回值是 tuple(list(A),list(B))
     */

    val s:Seq[(Long,Seq[Int])] = Seq(Tuple2(2L,seq))
    val tuple = s.partition(_._2.nonEmpty)
    //tuple:(List((2,List(1, 2, 3))),List())
    println(s"tuple:${tuple}")

    val (result1,result2) = s.partition(_._2.nonEmpty)
    //List((2,List(1, 2, 3)))
    println(result1)
    //List()
    println(result2)

    val tuple1 = List(1, 2, 3).partition(_ > 2)
    //tuple1:(List(3),List(1, 2))
    println(s"tuple1:${tuple1}")



  }

}
