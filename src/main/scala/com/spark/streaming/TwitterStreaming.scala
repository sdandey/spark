package com.spark.streaming

import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}
import twitter4j.Status

/**
  * Created by miru on 10/11/2016.
  */
object TwitterStreaming {
  def main(args: Array[String]) {
    System.setProperty("twitter4j.oauth.consumerKey","uL6sRIqSGmKrDdKqDbyEWP7qz")
    System.setProperty("twitter4j.oauth.consumerSecret","PVQJxhaVgHYZeUHt2AxGaJRv2CqzDYkz1iXqcrCMOoHiqhwScw")
    System.setProperty("twitter4j.oauth.accessToken","24646434-6Xy4TSHm156I6EKAvFXUzkkxvPUiOO1UsYVfTaBKS")
    System.setProperty("twitter4j.oauth.accessTokenSecret","jgf5THjRbLwRVXxaoAiwel3axqSwcIwyxqwzu1b8sF7Vl")

    val conf = new SparkConf().setAppName("Top Hash Tags")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))
   // ssc.checkpoint("file:///StreamingCheckpoint")

    val twitterStream = TwitterUtils.createStream(ssc, None)
    twitterStream.flatMap(tweet=>getHashTags(tweet))
      .countByValueAndWindow(Seconds(15), Seconds(10))
      .map(tagCountTuple => tagCountTuple.swap)
      .transform(rdd => rdd.sortByKey(false))
      .print

    ssc.start()
    ssc.awaitTermination()
   }

  def getHashTags(tweet: Status) = {
    raw"(?:(?<=\s)|^)#(\W*[A-Za-z_]+\W*)".r
      .findAllIn(tweet.getText).matchData
      .map(x=>x.group(1)).toList
  }
}
