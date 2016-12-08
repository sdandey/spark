package com.spark.streaming

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by miru on 10/9/2016.
  */
object HelloStreaming {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Word Counter")
    val ssc = new StreamingContext(conf, Seconds{10})
    val lines = ssc.socketTextStream("localhost",9999)
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(word => (word,1)).reduceByKey(_ + _)
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
