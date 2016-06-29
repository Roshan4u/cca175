import scala.util.matching.Regex

object RegEx {
	def main(Args: Array[String] {
		val patter = "Scala".r
		val str = "Scala is difficult to learn, but rewarding to can. Scala is future"
		println(pattern findFirstIn str)
	}
}