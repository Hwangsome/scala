package com.bh.collect.traverables

/**
 * Traverable 是一个特质，它的子特质 immutable.Traverable 和 mutable.Traverable 分别是不可变集合和可变集合的父特质。
 */
object TraverableDemo {
  def main(args: Array[String]): Unit = {
    //创建空的Traverable 对象。
    val t1 =Traversable.empty[Int]
    val t2 = Traversable[Int]()
    val t3 =Nil

    //创建带参数的Traverable 对象
    //方式1： 通过toTraversable（）方法实现
    val t4 = List(1, 2, 3).toTraversable
    val t41 = Set(1, 2, 3).toTraversable
    // 方式2 通过Traversable的伴生对象apply()方法实现
    val t5 = Traversable(1, 2, 3)//默认生成List


    /**
     * 转置：
     * 使用 transpose 方法。类似列变行
     * 转置操作时，需要每个集合的元素个数相同。
     */
    val t6 = Traversable(Traversable(1, 4, 7), Traversable(2, 5, 8), Traversable(3, 6, 9))
    println(t6)//List(List(1, 4, 7), List(2, 5, 8), List(3, 6, 9))
    val transpose = t6.transpose
    println(transpose)//List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))


    /**
     * 拼接：
     * ++ 可以拼接数据，但是会创建大量临时集合，可以通过 concat 方法实现。
     */
    val t7 = Traversable(1, 2, 3)
    val t8 = Traversable(4, 5, 6)
    val traversable = Traversable.concat(t7, t8)
    println(traversable)//List(1, 2, 3, 4, 5, 6)

    /**
     * 筛选：
     * 利用 collect 方法实现偏函数结合集合使用，从集合中筛选指定数据。
     * def collect[B](pf :PartialFunction[A, B]):Traversable[B]
     * 1. [B]表示通过偏函数处理后，返回值的类型，[A]表示经过偏函数处理之前的元素的数据类型
     * 2. pf :PartialFunction[A, B] 表示collect()方法需要传入一个偏函数对象
     * 3. Traversable[B] 表示返回值的具体数据的集合
     *
     */
    val t9 = Traversable(1, 2, 3)
    t9.collect[Int]({
      case x if x%2 ==0 =>x
    })

    /**
     * scan 方法
     * def scan[B](z:B)(op: (B, B) => B)
     * [B] 表示返回值的数据类型，(z:B)表示初始化值，(op: (B, B) => B)表示具体的函数运算。
     * 示例：定义 traversable 集合，存储1-5，假设初始值为1，分别获取每个元素的阶乘值。
     */
    val t10 = 1 to 5
    //val seq = t1.scan(1)((a, b) => a * b)
    val seq = t10.scan(1)(_ * _)
    println(seq)//Vector(1, 1, 2, 6, 24, 120)

    /**
     * 获取集合指定元素
     * head/last ： 获取第一个/最后一个元素，不存在抛出异常
     * headOption/lastOption ： 获取获取第一个/最后一个元素，返回值是 Option
     * find： 查找符号条件的第一个元素
     * slice ：截取集合中的一部分元素，左闭右开
     */
    println(t10.head)//1
    println(t10.last)//5
    println(t10.headOption)//Some(1)
    println(t10.lastOption)//Some(5)
    println(t10.find(_ % 2 == 0))//Some(2)
    println(t10.slice(0, 2))//Vector(1, 2)

    /**
     * 判断元素是否合法
     * forall 如果集合中所有元素都满足条件返回 true
     * exist 如果集合中有一个元素满足条件返回 true
     */
    println(t10.forall(_ % 2 == 0))//false
    println(t10.exists(_ % 2 == 0))//true

    /**
     * 聚合函数
     * count 统计集合中满足条件的元素个数
     * sum 获取集合元素和
     * product 获取集合中所有元素成绩
     * max 获取集合中所有元素最大值
     * min 获取集合中所有元素最小值
     */


    /**
     * 集合类型转换
     * toList
     * toSet
     * toArray
     * toSeq
     */
  }
}
