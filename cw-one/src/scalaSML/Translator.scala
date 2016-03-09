package scalaSML

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val SUB = "sub"
  private final val MUL = "mul"
  private final val DIV = "div"
  private final val OUT = "out"
  private final val BNZ = "bnz"


  // word + line is the part of the current line that's not yet processed
  // word has no whitespace
  // If word and line are not empty, line begins with whitespace

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */

    def readAndTranslate(m: Machine): Machine = {
      val labels = m.labels
      var program = m.prog
      import scala.io.Source
      val lines = Source.fromFile(fileName).getLines
      for (line <- lines) {
        val fields: Array[java.lang.String] = line.split(" ")
        if (fields.length > 0) {
          labels.add(fields(0))
          val className = "scalaSML." + fields(1).charAt(0).toUpper + fields(1).substring(1) + "Instruction"
          val c = Class.forName(className);
          if (c != null) {
            val apply = Class.forName(className).getMethods().find(m => m.getName().equals("apply")).get
            val types = apply.getParameterTypes
            for (i <- 0 until types.length) {
              println(types(i))
            }
            var args = Seq[Any]()
            for (i <- 0 until fields.length) {

                if (i == 0) {
                  args = args.:+ (fields(i))
                } else if(i != 1) {
                   types(i-1).toString match {
                    case "int" =>  args = args.:+ (fields(i).toInt)
                    case "class java.lang.String" => args = args.:+ (fields(i))
                  }
                }
                println("completed fields" + i)

            }

            val argsObjects = args.map(a => a.asInstanceOf[Object])

            val instance = apply.invoke(this, argsObjects: _*).asInstanceOf[Instruction]
            program = program :+ instance
          } else {
            println("Unknown instruction " + fields(1))
          }
        }
      }
      new Machine(labels, program)
    }

}

object Translator {
  def apply(file: String) =
    new Translator(file)
}