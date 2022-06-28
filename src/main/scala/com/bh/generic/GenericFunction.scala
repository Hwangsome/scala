package com.bh.generic

/**
 * 泛型方法
 */
object GenericFunction {
  def main(args: Array[String]): Unit = {

  }

  /**
   * 示例，定义一个泛型方法，获取任意数据类型的中间元素
   * @param array
   * @tparam T
   * @return
   */
  def getMiddleElement[T](array: Array[T]): T = {array(array.length / 2)}

}
