package game

import handlers.{ResponseHandler, CodeFactory, ColourHandler}
import com.softwaremill.macwire._
import pegs.ResponsePeg
import scala.io.StdIn

/**
  * Created by Oliver Coulson and George Shiangoli on 11/03/2016.
  */
class GameStatus(showCode: Boolean) extends Game{
  private val CODE_LENGTH: Int = 4
  private val NUMBER_OF_GUESSES = 12

  private val colourHandler = wire[ColourHandler]
  private val codeFactory = new CodeFactory(CODE_LENGTH)
  private val colourNumber = colourHandler.rawNames.length


  /**
    * Run one or more games of mastermind, until the player
    * quits.
    */
  override def runGames: Unit = {
    println("Welcome to Mastermind\n\n" +
            "This is a text version of the classic board game Mastermind.\n" +
            "The computer will think of a secret code.\n" +
            s"The code consists of $CODE_LENGTH colored pegs.\n" +
            s"The pegs may be one of $colourNumber colors: ${colourHandler.toString()}.\n" +
            "A color may appear more than once in the code." +
            "\n\n" +
            "You try to guess what colored pegs are in the code and what order they are in\n" +
            "After making a guess the result will be displayed.\n" +
            "A result consists of a black peg for each peg you have exactly correct " +
            "(color and position) in your guess.\n" +
            "For each peg in the guess that is the correct color, but is out of position, you get a white peg." +
            "\n\n" +
            "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
            "When entering guesses you only need to enter the first character of the color as a capital letter." +
            "\n\n" +
            s"You have $NUMBER_OF_GUESSES attempts to guess the answer or you lose the game")
    val guesses = Vector[Guess]()
    val responses = Vector[Response]()
    val guessResponseVector = guesses.zip(responses)
    gameLoop(guessResponseVector)
  }

  def gameLoop(guessesAndResponses: Vector[(Guess, Response)]): Unit = {
    println("Generating secret code...")
    val secretCode: SecretCode = codeFactory.generateSecretCode
    if (showCode) {
      println("The secret code is " + secretCode.toString())
    }
    println(s"You have ${NUMBER_OF_GUESSES - guessesAndResponses.length} guesses left\n")
    guessLoop(guessesAndResponses, secretCode, false)

    //TODO: Add user check for a new game.
  }

  def guessLoop(guessesAndResponses: Vector[(Guess, Response)], code: SecretCode, invalidGuess: Boolean): Unit = {
    //TODO: END Condition (i.e. win or run out of guesses)
    println("What is your next guess?\nType in the characters for your guess and press Enter.")
    print("Enter guess: ")

    val input = StdIn.readLine()
    println()
    val guessOption = codeFactory.processGuess(input)
    guessOption match {
        //TODO: Check whether the boolean flag is necessary
      case None => guessLoop(guessesAndResponses, code, true)
      case _ => val guess = guessOption.get
        val responseHandler: ResponseHandler = wire[ResponseHandler]
        val response: Response = responseHandler.getResponse(guess)
        //TODO: Check the response is not the appropriate number of blacks
        if(showCode) println(s"${code.toString} Secret Code")
        else println(".... Secret Code")
        val zipped: Vector[(Guess, Response)] = (Vector[Guess](guess).zip(Vector[Response](response)))
        val newGuesses: Vector[(Guess, Response)] = guessesAndResponses ++ zipped
        newGuesses.foreach(g => println(g._1.toString + " Result: " + g._2.toString))
        val remainingGuesses = NUMBER_OF_GUESSES - newGuesses.length
        for (i <- 0 until remainingGuesses) {
          println("....")
        }
        //TODO: Complete the guessloop, passing the new guess/response vector and the code in
    }

  }
}

