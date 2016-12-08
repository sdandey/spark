package com.amplab.scala.lab

import java.text.DateFormat
import java.text.DateFormat._
import java.util.{Date, Locale}

/**
  * Created by miru on 10/9/2016.
  */
object FrenchDate {

  def main(args: Array[String]) {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRENCH)
    println(df format now)
  }

}
