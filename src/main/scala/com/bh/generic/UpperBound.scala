package com.bh.generic

/**
 * 上界
 * 使用 T <: 类型名
 * 表示给类型添加一个上界，表示该类型必须是 T 或 T 的子类。
 *
 * 下界
 * 使用 T >: 类型名 表示给类型添加一个下界，表示该类型必须是 T 或 T 的父类。
 * 如果泛型既有上界又有下界，下界写在前面，[T >: A <: B]
 */
object UpperBound {
  class Person

  class Student extends Person

  def demo[T <: Person](array: Array[T]): Unit = println(array)

  def main(args: Array[String]): Unit = {
    demo(Array(new Person))
    demo(Array(new Student))
    //demo(Array("a"))//报错
  }
}
