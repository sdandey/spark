package com.amplab.scala.lab
import java.lang._
import com.sun.glass.ui.MenuItem.Callback

/**
  * Created by miru on 10/9/2016.
  */
object Timer {
  def oncePerSecond(callback: () => Unit) {
    while (true) {
      callback(); Thread sleep 1000
    }
  }
  def timeFlies(): Unit = {
    println("time flies like an arrow..")
  }

  def main(args: Array[String]) {
    oncePerSecond(timeFlies)
  }

}
