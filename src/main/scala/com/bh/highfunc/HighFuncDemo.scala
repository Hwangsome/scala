package com.bh.highfunc

/**
 * 高阶函数是指使用其他函数作为参数、或者返回一个函数作为结果的函数。
 * 在Scala中函数是“一等公民”，所以允许定义高阶函数。
 * 这里的术语可能有点让人困惑，我们约定，使用函数值作为参数，
 * 或者返回值为函数值的“函数”和“方法”，均称之为“高阶函数”。
 */
object HighFuncDemo {
  def main(args: Array[String]): Unit = {
    /**
     * 函数doubleSalary有一个整型参数x，返回x * 2。
     * 一般来说，在=>左边的元组是函数的参数列表，而右边表达式的值则为函数的返回值。
     * 在第3行，函数doubleSalary被应用在列表salaries中的每一个元素。
     */
    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x: Int) => x * 2
    val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
    newSalaries.foreach(println)

    /**
     * 为了简化压缩代码，我们可以使用匿名函数，直接作为参数传递给map:
     * 注意在下述示例中x没有被显式声明为Int类型，这是因为编译器能够根据map函数期望的类型推断出x的类型。对于上述代码，一种更惯用的写法为：
     * 既然Scala编译器已经知道了参数的类型（一个单独的Int），你可以只给出函数的右半部分，不过需要使用_代替参数名（在上一个例子中是x）
     */
    val newSalaries2 = salaries.map(x => x * 2)
    newSalaries2.foreach(println)
    val newSalaries3 = salaries.map(_ * 2)
    newSalaries3.foreach(println)
  }
}
