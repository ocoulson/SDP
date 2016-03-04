package sml

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
//    def readAndTranslate(m: Machine): Machine = {
//      val labels = m.labels
//      var program = m.prog
//      import scala.io.Source
//      val lines = Source.fromFile(fileName).getLines
//      for (line <- lines) {
//        val fields = line.split(" ")
//        if (fields.length > 0) {
//          labels.add(fields(0))
//          fields(1) match {
//            case ADD =>
//              program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//            case LIN =>
//              program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
//            case SUB =>
//              program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//            case MUL =>
//              program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//            case DIV =>
//              program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//            case OUT =>
//              program = program :+ OutInstruction(fields(0), fields(2).toInt)
//            case BNZ =>
//              program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
//            case x =>
//              println(s"Unknown instruction $x")
//          }
//        }
//      }
//      new Machine(labels, program)
//    }

    def readAndTranslate(m: Machine): Machine = {
      val labels = m.labels
      var program = m.prog
      import scala.io.Source
      val lines = Source.fromFile(fileName).getLines
      for (line <- lines) {
        val fields: Array[java.lang.String] = line.split(" ")
        if (fields.length > 0) {
          labels.add(fields(0))
          val className = fields(1).charAt(0).toUpper + fields(1).substring(1) + "Instruction"
          val c = Class.forName(className);
          if (c != null) {
            val constructor = Class.forName(className).getMethods().find(m => m.getName().equals("apply")).get
            val parameterTypes = constructor.getGenericParameterTypes
            var args = Seq[Object]()
            var i = 0
            for (i <- 0 until parameterTypes.length - 1) {
                if (i != 1) {
                  args = args.+: (fields(i).asInstanceOf[java.lang.Object])
                }
            }
            val instance = constructor.invoke(this, args: _*).asInstanceOf[Instruction]
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