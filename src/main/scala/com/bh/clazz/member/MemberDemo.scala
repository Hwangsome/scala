package com.bh.clazz.member

object MemberDemo {
  def main(args: Array[String]): Unit = {
    val point1 = new Point
    point1.x = 99
    //WARNING: Out of bounds
    point1.y = 101 // prints the warning
  }
}

/**
 * 在这个版本的Point类中，数据存在私有变量_x和_y中。def x和def y方法用于访问私有数据。
 * def x_=和def y_=是为了验证和给_x和_y赋值。
 * 注意下对于setter方法的特殊语法：这个方法在getter方法的后面加上_=，后面跟着参数。
 */
class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}
//主构造方法中带有val和var的参数是公有的。然而由于val是不可变的，所以不能像下面这样去使用。
