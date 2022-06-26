package com.bh.collectfunction

object CollectDemo {
  def main(args: Array[String]): Unit = {
    val site: List[String] = List("Runoob", "Google", "Baidu")
    val tuple = site.partition(_.contains('u'))
    //(List(Runoob, Baidu),List(Google))
    println(tuple)
    println(tuple._1)
    println(tuple._2)
  }
}
