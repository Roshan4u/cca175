import scala.util.matching.Regex

object RegEx {
	def main(Args: Array[String] {
		val pattern = "(/d+) ([A-Za-z]+)".r
		val str = List("we garether 10 salads",
			"but we lost 9 leaves",
			"nobody know how many bananas there",
			"something aroun 100 bananas")
		println(pattern(str))
	}
}