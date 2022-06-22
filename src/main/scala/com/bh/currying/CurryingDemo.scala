package com.bh.currying

/**
 * 是什么？
 * 柯里化（Currying）是把接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，并且返回接受余下的参数且返回结果的新函数的技术。
 * 从数学的角度讲，这是一个对函数消元求解的过程。
 *
 * 为什么要使用柯里化?
 * 1.把多个参数转化为单参数函数的级联，达到了动态确定参数的目的。
 * 2.当某些参数不确定时，可以先保留一个存根。剩余的参数确定以后，就可以通过存根调用剩下的参数。
 * 3.通过类似于建造者模式(building)，把一个大的东西的构造过程，切成一个个的小模块来逐步构造。
 * 举个最简单的例子，Person.name("xxx").age(num).salary(count).phone(xxxx)。
 *
 * curry化最大的意义在于把多个参数的函数等价转化成多个单参数函数的级联，这样所有的函数就都统一了，
 * 方便做`lambda`演算。 在scala里，curry化对类型推演也有帮助，scala的类型推演是局部的，
 * 在同一个参数列表中后面的参数不能借助前面的参数类型进行推演，curry化以后，放在两个参数列表里，
 * 后面一个参数列表里的参数可以借助前面一个参数列表里的参数类型进行推演。
 *
 * 柯里化的好处？
 * 1. 简化嵌套函数的开发
 * 2. 可以支持更多的语法
 */
object CurryingDemo {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    val strFoldLeft = list.foldLeft("strFoldLeft=")((x: String, y: Int) => x + y)
    val reduceLeftResult = list.reduceLeft(_ + _)
    println(s"reduceLeftResult=${reduceLeftResult}")
    println(strFoldLeft)

    println(mergeWithCurrying("a")("b"))

    println(mergeWithCurrying2("a")("b")(_+_))
  }

  def add(x: Int, y: Int) = x + y

  /**
   * addWithCurrying :调用的方式为 addWithCurrying(1)(2)
   * 这种方式就叫做柯里化。说得更加简单粗暴一点，有多个参数列表，或者说多个小括号括起来的函数参数列表的函数就是柯里化函数。
   *
   * @param x
   * @param y
   * @return
   *
   * 柯里化的演变过程：
   * def add(x: Int, y: Int) = x + y
   * 那么这个函数是什么意思呢？ 接收一个x为参数，返回一个匿名函数，该匿名函数的定义是：接收一个Int型参数y，函数体为x+y。现在我们来对这个方法进行调用。
   * def addWithCurrying(x: Int)= (y: Int)=>x+y  。addWithCurrying（1）=(y: Int)=>1+y 。addWithCurrying(1)(1) =>1+1
   * def addWithCurrying(x: Int)(y: Int) =x +y
   */
  def addWithCurrying(x: Int)(y: Int) = x + y

  /**
   * 柯里化使用案例：
   *
   */
    //普通写法
  def merge(s1: String, s2: String) = s1 + s2
  //柯里化写法
  def mergeWithCurrying(s1: String)(s2: String) =s1 + s2

  def mergeWithCurrying2(s1: String)(s2: String)(fun:(String,String)=>String):String =fun(s1,s2)
}
