package com.bh.clazz.traits

import scala.collection.mutable.ArrayBuffer

/**
 *  1. 最简化的特质就是关键字trait+标识符：eg :trait Iterator
 *  2. trait作为泛型类型和抽象方法非常有用。
 *  扩展 trait Iterator [A] 需要一个类型 A 和实现方法hasNext和next。
 *
 * @tparam A
 */
trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}

/**
 * 使用trait
 * 这个类 IntIterator 将参数 to 作为上限。它扩展了 Iterator [Int]，这意味着方法 next 必须返回一个Int。
 */
class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0
  override def hasNext: Boolean = current < to
  override def next(): Int =  {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}
object TraitDemo{
  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)
    println(iterator.next())  // returns 0
    println(iterator.next())  // returns 1

    val dog = new Dog("Harry")
    val cat = new Cat("Sally")

    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
    animals.foreach(pet => println(pet.name))
  }
}

/**
 * 凡是需要特质的地方，都可以由该特质的子类型来替换。
 * 在这里 trait Pet 有一个抽象字段 name ，name 由Cat和Dog的构造函数中实现。最后一行，我们能调用pet.name的前提是它必须在特质Pet的子类型中得到了实现。
 */
trait Pet {
  val name: String
}
class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet