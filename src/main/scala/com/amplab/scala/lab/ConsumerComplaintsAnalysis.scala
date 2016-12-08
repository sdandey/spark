package com.amplab.scala.lab

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by santoshdandey on 12/5/16.
  */
object ConsumerComplaintsAnalysis {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("AMPLab6 Wiki Data Explore").config("", "").getOrCreate()
    val consumerDf = spark.read.format("com.databricks.spark.csv").option("header", "true").
      option("inferSchema", "true").
      load(args(0))

    consumerDf.coalesce(1).write.json(args(1))
  }
}
