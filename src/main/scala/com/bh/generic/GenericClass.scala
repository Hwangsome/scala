package com.bh.generic

object GenericClass {
  /**
   * 泛型类,示例，定义一个 Pair 泛型类，包含两个字段且字段类型不固定
   * @param a
   * @param b
   * @tparam T
   */
  class Pair[T](var a:T, var b:T)
}



