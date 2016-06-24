/* The Simple Scala App for Spark */
/* Line just to test physical link */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
	def main(args: Array[String]) {
		val logFile = "file:/home/cloudera/test.tsv"
		val conf = new SparkConf().setAppName("Simple Scala App")
		val sc = new SparkContext(conf)
		val logData = sc.textFile(logFile, 2).cache
		val numAs = logData.filter(line => line.contains("a")).count()
		val numBs = logData.filter(line => line.contains("b")).count()
		System.out.println("Lines with a: %s, \nLines with b: %s".format(numAs, numBs))		
}
}
