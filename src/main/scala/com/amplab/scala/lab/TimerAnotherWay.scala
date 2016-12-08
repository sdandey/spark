package com.amplab.scala.lab

import com.sun.glass.ui.MenuItem.Callback

/**
  * Created by miru on 10/9/2016.
  */
object TimerAnotherWay {

  def oncePerSecond(callback: () => Unit): Unit = {
    while(true) {
      callback(); Thread sleep 1000
    }
  }

  def main(args: Array[String]) {
    oncePerSecond(()=> println("Times Flies"))
  }
}
