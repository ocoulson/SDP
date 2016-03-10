import handlers.CodeFactory
import org.scalatest.FunSuite
import pegs.Colour

/**
  * Created by Oliver Coulson on 10/03/2016.
  */
class CodeHandlerTest extends FunSuite{
  test("A generated secretCode should be a given length") {
    var length = 4
    val secretCode = CodeFactory.generateSecretCode(length)
    assert(secretCode.length == length)

    length = 8
    val secretCode2 = CodeFactory.generateSecretCode(length)
    assert(secretCode2.length == length)
  }

  test("A SecretCode contains a vector of colours") {
    val secretCode = CodeFactory.generateSecretCode(4)
    val vector = secretCode.code
    assert(vector(0).isInstanceOf[Colour])
    assert(vector(1).isInstanceOf[Colour])
    assert(vector(2).isInstanceOf[Colour])
    assert(vector(3).isInstanceOf[Colour])
  }


}
