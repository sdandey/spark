name := "SparkLessons"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies += "com.google.code.gson" % "gson" % "2.7"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.0" % "provided"
// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming_2.10
libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.0.0" % "provided"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.10
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.0"


libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.11" % "1.6.1"
// https://mvnrepository.com/artifact/org.twitter4j/twitter4j-stream
libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "4.0.5"

// META-INF discarding
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
}