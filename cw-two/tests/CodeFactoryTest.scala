import handlers.{ColourFactory, CodeFactory}
import org.scalatest.FunSuite
import pegs.Colour

/**
  * Created by Oliver Coulson and George Shiangoli on 10/03/2016.
  */

class CodeFactoryTest extends FunSuite{

  val codeFactory4 = new CodeFactory(4)
  val codeFactory8 = new CodeFactory(8)
  //SecretCode tests
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

  //ProcessGuess tests
  test("A user guess of RBGY will return a Guess containing a vector of the correct object types") {
    val correctVector = Vector[Colour](ColourFactory.newColour('R').get, ColourFactory.newColour('B').get,
      ColourFactory.newColour('G').get, ColourFactory.newColour('Y').get)

    val userInput = "RBGY"
    val processedInput = codeFactory4.processGuess(userInput).get.code
    println("\n" + processedInput)
    val zipped = correctVector.zip(processedInput)
    assert(zipped.map(t => t._1 == t._2).reduce((b1, b2) => {
      if(!b1 || !b2) false
      else true
    }))
  }

  test("An incorrect letter will return None") {
    val processedInput = codeFactory4.processGuess("RRRZ")
    assert(processedInput == None)
  }

  test("All incorrect letters will return None") {
    val processedInput = codeFactory4.processGuess("AZQZ")
    assert(processedInput == None)
  }

  test("A lower case letter will return None") {
    val processedInput = codeFactory4.processGuess("RRRr")
    assert(processedInput == None)
  }

  test("A string of incorrect length will return None") {
    val processedInput = codeFactory4.processGuess("RRRGP")
    assert(processedInput == None)
  }

  test("An empty input will return None") {
    val processedInput = codeFactory4.processGuess("")
    assert(processedInput == None)
  }

}
