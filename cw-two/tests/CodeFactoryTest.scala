import handlers.CodeFactory
import org.scalatest.FunSuite
import pegs.Colour

/**
  * Created by Oliver Coulson and George Shiangoli on 10/03/2016.
  */

class CodeFactoryTest extends FunSuite{

  val codeFactory4 = new CodeFactory(4)
  val codeFactory8 = new CodeFactory(8)

  test("A generated secretCode should be a given length") {
    var length = 4
    val secretCode = codeFactory4.generateSecretCode
    assert(secretCode.length == length)

    length = 8
    val secretCode2 = codeFactory8.generateSecretCode
    assert(secretCode2.length == length)
  }

  test("A SecretCode contains a vector of colours") {
    val secretCode = codeFactory4.generateSecretCode
    val vector = secretCode.code
    assert(vector(0).isInstanceOf[Colour])
    assert(vector(1).isInstanceOf[Colour])
    assert(vector(2).isInstanceOf[Colour])
    assert(vector(3).isInstanceOf[Colour])
  }

  test("A SecretCode should be different from other SecretCodes") {
    val A = codeFactory4.generateSecretCode.code
    val B = codeFactory4.generateSecretCode.code
    val C = codeFactory4.generateSecretCode.code
    println(A)
    println(B)
    println(C)

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
