import com.google.gson.Gson
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by miru on 10/9/2016.
  */
object TwitterExample {
  private var numTweetsCollected = 0L
  private var partNum = 0
  private var gson = new Gson()

  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Word Counter")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile(args(0))
    //textFile partition this to 100 partitions
    textFile.repartition(100).persist()

    //you can re-shuffle the contents using the coalesce operation also with shuffle yes or no
    textFile.coalesce(numPartitions = 100, shuffle = true)
    textFile.toDebugString

  }
}
