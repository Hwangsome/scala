package com.bh.matchs

import scala.util.Random

object MatchDemo {
  def main(args: Array[String]): Unit = {
    /**
     * val x是一个0到10之间的随机整数，将它放在match运算符的左侧对其进行模式匹配，
     * match的右侧是包含4条case的表达式，其中最后一个case _表示匹配其余所有情况，
     * 在这里就是其他可能的整型值。
     *
     * match表达式具有一个结果值
     */
    val x: Int = Random.nextInt(10)
    x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    }
  }

  /**
   *   match表达式具有一个结果值
   *   这个match表达式是String类型的，因为所有的情况（case）均返回String，所以matchTest函数的返回值是String类型。
   */
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

  /**
   * 匹配类型
   * 当不同类型对象需要调用不同方法时，仅匹配类型的模式非常有用，如上代码中goIdle函数对不同类型的Device有着不同的表现。
   * 一般使用类型的首字母作为case的标识符，例如上述代码中的p和c，这是一种惯例。
   */
  abstract class Device
  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }
  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }

  /**
   * 密封类
   * 特质（trait）和类（class）可以用sealed标记为密封的，这意味着其所有子类都必须与之定义在相同文件中，从而保证所有子类型都是已知的。
   *
   * 这对于模式匹配很有用，因为我们不再需要一个匹配其他任意情况的case。
   */
  sealed abstract class Furniture
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }
}
