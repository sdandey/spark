package com.amplab.scala.lab.SparkSql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
/**
  * Created by miru on 10/22/2016.
  */
object WikiDataExplore {

  def main(args: Array[String]) {

    val spark = SparkSession.builder().appName("AMPLab6 Wiki Data Explore").config("","").getOrCreate();
    val wikiData = spark.read.parquet("C:\\ampcamp\\ampcamp6\\data\\wiki.parquet");

  }

}
