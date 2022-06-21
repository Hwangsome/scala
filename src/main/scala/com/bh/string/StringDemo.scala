package com.bh.string

object StringDemo {
  def main(args: Array[String]): Unit = {
    val str = "hello world"
    val result =s"""
       |CREATE TABLE IF NOT EXISTS ${str} (
       |${str}
       |)
       |COMMENT '${str}'
       |row format delimited
       |fields terminated by ','
       |stored as Parquet
       |TBLPROPERTIES ('creator'='bh', 'owner'='bh@qq.com');""".stripMargin
    println(result)
  }
}

