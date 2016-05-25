

package regex

object RegExReal {
  
  
	def main(args: Array[String]): Unit = {
	  
	  val addressPattern = """\b([A-Z][a-zA-Z]+ )?[A-Z][a-zA-Z]+, [A-Z]{2} [0-9]{5}\b""".r 
	  (addressPattern findAllIn "Mark Frymire was born in Pekin, IL 61554") foreach println
	  (addressPattern findAllIn "Mark Frymire was born in Las Vegas, NV 61554") foreach println

	  val emailPattern = """\b[\w._%+-]+@[\w.-]+\.[a-zA-Z]{2,4}\b""".r
	  val emailLine = "Mark Frymire mark.e.frymire@dac.us"
	  (emailPattern findAllIn emailLine) foreach println
	  println( emailPattern.replaceAllIn(emailLine, "").trim )
	  
	  val nameRegex = """([\p{Lu}][\p{L}�\-]+ (\p{Lu}\.? )?)([\p{Lu}][\p{L}�\-]+( III)?)""".r
	  val nameLine = "Piyush Rai and Hal Daume� III"
      val names = (for (author <- (nameRegex findAllIn nameLine)) yield author.split(" ").last).toArray
      names foreach println

      val nameExtractor = """([\p{Lu}][\p{L}�\-]+)( \p{Lu}\.?)?( [\p{Lu}][\p{L}�\-]+)( III)?""".r
      val fullNames = nameExtractor.findAllIn("Mark Frymire III and Kurt W. Frymire")
      for (nameExtractor(first, middle, last, suffix) <- fullNames) {
    	  println("First: " + first)
    	  println("Middle: " + middle)
    	  println("Last: " + last)
    	  println("Suffix: " + suffix)       
    	  println
      }      

	}
}