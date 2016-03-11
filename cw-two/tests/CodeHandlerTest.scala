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

  test("A SecretCode should be different from other SecretCodes") {
    val A = CodeFactory.generateSecretCode(4).code
    val B = CodeFactory.generateSecretCode(4).code
    val C = CodeFactory.generateSecretCode(4).code

    val AB = A.zip(B)
    val AC = A.zip(C)
    val BC = B.zip(C)

    var ABequal: Boolean = true
    var ACequal: Boolean = true
    var BCequal: Boolean = true

    AB.foreach(tuple => if(!tuple._1.equals(tuple._2)) ABequal = false)
    AC.foreach(tuple => if(!tuple._1.equals(tuple._2)) ACequal = false)
    BC.foreach(tuple => if(!tuple._1.equals(tuple._2)) BCequal = false)

    assert(!ABequal && !ACequal && !BCequal)

  }

}
