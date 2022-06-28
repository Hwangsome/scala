package com.bh.highfunc

/**
 * reduce 和 fold
 * 示例：计算1-10的和，reduce 相当于 reduceLeft，如果想从右到左计算使用 reduceRight
 */
object ReduceFoldDemo {
  def main(args: Array[String]): Unit = {
    val list = (1 to 10).toList
    //x表示聚合操作的结果，y表示下一个元素
    var i = list.reduce((x, y) => x + y)
    //简化
    i = list.reduce(_ + _)
    println(i)//55

    //fold 和 reduce 很像，只是 fold 多了一个指定初始化值参数
    //fold 相当于 foldLeft，如果想从右到左计算使用 foldRight
    //示例：定义一个列表包括1-10，假设初始化值100，计算所有元素和
    val list2 = (1 to 10).toList
    //x表示聚合操作的结果，y表示下一个元素
    val j = list2.fold(100)(_ + _)
    println(j)//155
  }

}
