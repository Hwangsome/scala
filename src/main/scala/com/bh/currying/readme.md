## 柯里化在scala源码中的解释
```scala
def foldLeft[B](z: B)(@deprecatedName('f) op: (B, A) => B): B = {
    var acc = z
    var these = this
    while (!these.isEmpty) { //传进来的集合不为空
      acc = op(acc, these.head) // 自定义方法的实现传进来：比如 阶乘，累加... 
      these = these.tail // 每次操作以后 取剩下的集合
    }
    acc // 返回最终的值
  }
```

## Scala中下划线“_”的用法小结
https://www.jianshu.com/p/d271afce8c71
1. 匿名函数参数占位符
当匿名函数传递给方法或其他函数时，如果该匿名函数的参数在=>的右侧只出现一次，那么就可以省略=>，并将参数用下划线代替。这对一元函数和二元函数都适用。
```shell
scala> val list = List(5,3,7,9,1)
list: List[Int] = List(5, 3, 7, 9, 1)

// list.map(x => x * 10)
scala> list.map(_ * 10)
res0: List[Int] = List(50, 30, 70, 90, 10)

// list.sortWith((x, y) => x < y)
scala> list.sortWith(_ < _)
res1: List[Int] = List(1, 3, 5, 7, 9)

// list.reduceLeft((x, y) => x + y)
scala> list.reduceLeft(_ + _)
res2: Int = 25
```
2. 无用匿名函数参数
当匿名函数的参数未被实际使用到时，可以不给它一个命名，而直接用下划线代替。例：
```shell
scala> list.foreach(_ => println("Hello Scala"))
Hello Scala
Hello Scala
Hello Scala
Hello Scala
Hello Scala
```
3. 泛型定义中的通配符
在Java中用问号来指代泛型中不确定类型的定义（如List<?>）。Scala用下划线来代替它，例：
```shell
 scala> def testPrint(l: List[_]) = {
     |   list.foreach(x => println(x))
     | }
testPrint: (l: List[_])Unit
```
4. 模式匹配中的通配符/占位符
得益于Scala模式匹配（pattern matching）的强大，下划线在模式匹配中的用途非常灵活。它除了可以用来代替Java switch-case表达方式中的default之外，还可以占位表示其他元素甚至类型。例：
```scala
 str match {
  case 1 => "one"
  case 2 => "two"
  // 如同Java中的default
  case _ => "anything other than one and two"
}

expr match {
  // 以1开头，且长度为3的List
  case List(1,_,_) => "a list with three element and the first element is 1"
  // 长度大于等于0的List
  case List(_*)  => "a list with zero or more elements"
  // 键和值类型都为任意类型的Map
  case Map[_,_] => "matches a map with any key type and any value type"
  case _ =>
}
```
5. 导入语句中的通配符
6. 变量默认值初始化
用下划线可以自动在变量声明时，将其赋予默认的初始值。
```scala
scala> var name : String = _
name: String = null

scala> var count : Int = _
count: Int = 0

scala> var avg : Double = _
avg: Double = 0.0
```
7. 访问元组（tuple）
   下划线后面跟上数字k，可以当作索引表示元组中的第k个元素。当要忽略元组中的某个值时，也可以用下划线代替它
```scala
scala> val tuple = ("LMagics", 173.5, Seq(22,66,88))
tuple: (String, Double, Seq[Int]) = (LMagics,173.5,List(22, 66, 88))

scala> tuple._1
res1: String = LMagics

scala> tuple._2
res2: Double = 173.5

scala> tuple._3
res3: Seq[Int] = List(22, 66, 88)

scala> val (first, _, third) = tuple
first: String = LMagics
third: Seq[Int] = List(22, 66, 88)
```
8. 声明setter方法
   Scala中没有显式的setter方法，将getter方法的命名后加上一个下划线，就可以当作setter方法使用。例：
```shell
 scala> class Test {
     |   private var pCount = 0
     |   def count = pCount  // getter
     |   def count_= (c : Int) = {  // setter
     |     require(c > 0)
     |     pCount = c
     |   }
     | }
defined class Test

scala> val test = new Test()
test: Test = Test@27d5a580

scala> test.count = 7
test.count: Int = 7
```
9. 变长参数的转化
10. 将方法转换成函数
    我们都知道Scala中方法与函数的不同点。其中最显著的不同就在于，函数在Scala中是一种对象实例，因此它可以赋值给变量，也可以作为参数。如果方法在赋值时直接写名称的话，编译器会认为是对方法的调用，因此会报没有参数列表的错误。在方法名称后加一个下划线，会将其转化为偏应用函数（partially applied function），就能直接赋值了。例：
```shell
 scala> def twoSum(a: Int, b: Int) = a + b
twoSum: (a: Int, b: Int)Int

scala> val twoSumFunc = twoSum _
twoSumFunc: (Int, Int) => Int = <function2>

scala> list foreach println _
5
3
7
9
1
```
11. 定义偏应用函数
既然偏应用函数就是不提供或者只提供部分参数调用时返回的函数，我们也可以用下划线来代替那些不提供的参数。例：
```scala
scala> def threeMult(a: Int, b: Int, c:Int) = a * b * c
threeMult: (a: Int, b: Int, c: Int)Int

scala> val parThreeMult = (8, _: Int, 42)
parThreeMult: Int => (Int, Int, Int) = <function1>
```