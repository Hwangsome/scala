package com.bh.singletonobject

import com.bh.singletonobject.Logger.info
/**
 * 单例对象是一种特殊的类，有且只有一个实例。和惰性变量一样，单例对象是延迟创建的，当它第一次被使用时创建。
 * 当对象定义于顶层时(即没有包含在其他类中)，单例对象只有一个实例。
 * 当对象定义在一个类或方法中时，单例对象表现得和惰性变量一样。
 */
object SingletonobjectDemo {
  def main(args: Array[String]): Unit = {
    info("aaa")
  }
}

/**
 * 定义一个单例对象
 * 一个单例对象是就是一个值。单例对象的定义方式很像类，但是使用关键字 object：
 */
object Box


/**
 * 下面例子中的单例对象包含一个方法：
 * 方法 info 可以在程序中的任何地方被引用。像这样创建功能性方法是单例对象的一种常见用法。
 *
 * import com.bh.singletonobject.Logger.info
 * 使用的时候 导入即可
 */
object Logger {
  def info(message: String): Unit = println(s"INFO: $message")
}