package com.amplab.scala.lab.SparkSql

import java.util.Properties

import org.apache.spark.sql.SparkSession

/**
  * Created by santoshdandey on 12/6/16.
  */
object ConsumerDataJdbc {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("AMPLab6 Wiki Data Explore").config("","").getOrCreate()
    val consumerDf = spark.read.parquet("/Users/santoshdandey/Documents/data/consumerDataParquet/*.parquet")
    consumerDf.printSchema()
    consumerDf.show(10)
    val properties = new Properties();
    properties.setProperty("user","root");
    properties.setProperty("password","san007");
    consumerDf.write.jdbc("jdbc:mysql://localhost:3306","user.consumerData",properties)



  }
}
