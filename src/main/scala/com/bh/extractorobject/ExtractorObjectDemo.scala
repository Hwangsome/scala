package com.bh.extractorobject

import scala.util.Random

/**
 * 提取器对象是具有unapply方法的对象。apply该方法就像一个构造函数，它接受参数并创建一个对象，
 * 而该方法unapply接受一个对象并尝试返回参数。这最常用于模式匹配和偏函数。
 */
object ExtractorObjectDemo {
  def main(args: Array[String]): Unit = {
    val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
    customer1ID match {
      case CustomerID(name) => println(name)  // prints Sukyoung
      case _ => println("Could not extract a CustomerID")
    }
  }
}

object CustomerID {

  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}
