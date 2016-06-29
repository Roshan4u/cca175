import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

// the class joins disparate datasets, 

object JoinTo {
	def main(args: Array[String]) {
		// we dont know how to check the number of arguments
		val sc = new SparkContext(new SparkConf().setAppName("Join datasets"))

		// we forgot what to do next
		// take first file
		val firstFile = sc.textFile(args(0))
		// take second file
		val secondFile = sc.textFile(args(1))
		// joining together... ok maybe unioning
		val joined = firstFile.union(secondFile)
		// what we do next?
		// trying to save this 'whatever'
		// how it feels to save it as text?
		// you forgot something...
		val asOnePartition = joined.coalesce(1)
		// then, move on
		asOnePartition.saveAsTextFile(args(2))
		// and remember to use SparkContext.objectFile() with...
		// ... well, you know, objectFiles
		asOnePartition.saveAsObjectFile(args(3))
		// "I think we done, here" oh man... forgot to turn on
		System.out.println("I thing we done, here")
	}
}