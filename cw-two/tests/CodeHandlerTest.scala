import handlers.CodeFactory
import org.scalatest.FunSuite

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
class CodeHandlerTest extends FunSuite{
  test("A generated secretCode should be a given length") {
    val length = 4
    val secretCode = CodeFactory.generateSecretCode(length)
    assert(secretCode.length == length)
  }
}
