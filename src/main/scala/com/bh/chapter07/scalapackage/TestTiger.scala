package com.bh.chapter07.scalapackage.hello

import com.bh.chapter07.scalapackage.xh.Tiger

/**
 * 
 */
object TestTiger {
  def main(args: Array[String]): Unit = {
    //使用xh的Tiger
    val tiger1 = new Tiger
    //使用xm的Tiger
    val tiger2 = new com.bh.chapter07.scalapackage.xm.Tiger
    println(tiger1 + " " + tiger2)

  }
}

/**
 * scala 中包名和源码所在系统文件目录结构可以不一致，但是编译后的字节码文件路径和包名保持一致（这个工作由编译器完成）
 * 比如这个 Employee类会被编译在com.bh.chapter07.scalapackage.hello 包下
 */
class Employee {

}

