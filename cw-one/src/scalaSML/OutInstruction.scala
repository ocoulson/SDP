package scalaSML

/**
  * Created by Oliver Coulson on 04/03/2016.
  */
class OutInstruction(label: String, opcode: String, register: Int) extends Instruction(label, opcode) {

  override def execute(m: Machine): Unit = {
    println(m.regs(register))
  }

  override def toString(): String = {
    super.toString + " Print contents of register " + register + "\n"
  }
}

object OutInstruction {
  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)
}
