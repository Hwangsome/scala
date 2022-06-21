# 类
Scala中的类是用于创建对象的蓝图，其中包含了方法、常量、变量、类型、对象、特质、类，这些统称为成员
## 类定义
一个最简的类的定义就是关键字class+标识符，类名首字母应大写。
```scala
class User

val user1 = new User
```
关键字new被用于创建类的实例。User由于没有定义任何构造器，因而只有一个不带任何参数的默认构造器。然而，你通常需要一个构造器和类体。下面是类定义的一个例子：
```scala
object ClazzDemo {
  def main(args: Array[String]): Unit = {
    val point1 = new Point(2, 3)
    point1.x  // 2
    println(point1)  // prints (2, 3)
  }
}
class Point(var x: Int, var y: Int) {

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String =
    s"($x, $y)"
} // prints (2, 3)
```
Point类有4个成员：变量x和y，方法move和toString。与许多其他语言不同，
主构造方法在类的签名中(var x: Int, var y: Int)。move方法带有2个参数，
返回无任何意义的Unit类型值()。这一点与Java这类语言中的void相当。
另外，toString方法不带任何参数但是返回一个String值。
因为toString覆盖了AnyRef中的toString方法，所以用了override关键字标记。