package com.bh.generic

object GenericTrait {
  trait Logger[T]{
    val a:T

    def show(b:T)
  }

  object ConsoleLogger extends Logger[String]{
    override val a: String = "sjh"

    override def show(b: String): Unit = println(b)
  }

}
