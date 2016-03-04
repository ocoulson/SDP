package sml

/**
  * Created by Oliver Coulson on 04/03/2016.
  */
case class BnzInstruction(label: String, opcode: String, register: Int, nextLabel: String) extends Instruction(label, opcode) {

  override def execute(m: Machine): Unit = {
    if (m.regs(register) != 0) {
        m execute m.labels.labels.indexOf(nextLabel)
    }
  }

  override def toString(): String = {
    super.toString + " If " + register + " is not 0, jump back to line " + nextLabel
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, nextLabel: String) =
    new BnzInstruction(label, "bnz", register, nextLabel)
}
