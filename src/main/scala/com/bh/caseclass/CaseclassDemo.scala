package com.bh.caseclass

object CaseclassDemo {
  def main(args: Array[String]): Unit = {
    val frankenstein1 = Book("978-0486282114","穷途末路")
    val frankenstein2 = Book("978-0486282114","穷途末路")

    /**
     * 比较
     * 案例类在比较的时候是按值比较而非按引用比较：
     * 尽管frankenstein1和frankenstein2引用不同的对象，但是他们的值是相等的，所以frankenstein1 == frankenstein2为true
     */
    println(frankenstein1 == frankenstein2)

    /**
     * 拷贝
     * 你可以通过copy方法创建一个案例类实例的浅拷贝，同时可以指定构造参数来做一些改变。
     *
     * frankenstein3  ==> Book(978-0486282114,zero2Hero)
     */
    val frankenstein3 = frankenstein1.copy(name = "zero2Hero")
    println(frankenstein3)

  }
}

/**
 * 注意在实例化案例类Book时，并没有使用关键字new，这是因为案例类有一个默认的`apply`方法来负责对象的创建。
 * 当你创建包含参数的案例类时，这些参数是公开（public）的val (public final 不可变的~)
 *
 * 你不能给frankenstein1.isbn重新赋值，因为它是一个val（不可变）。在案例类中使用var也是可以的，但并不推荐这样。
 */
case class Book(isbn: String,name:String)
