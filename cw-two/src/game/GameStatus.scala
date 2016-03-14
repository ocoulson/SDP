package game

import handlers.{ResponseHandler, CodeFactory, ColourHandler}
import com.softwaremill.macwire._
import pegs.Black
import scala.io.StdIn

/**
  * An implementation of the Game trait. Contains constants representing the game's parameters
  * i.e. the length of the secret code and the number of guesses the player has.
  * It also holds references to the necessary
  * Created by Oliver Coulson and George Shiangoli on 11/03/2016.
  */
class GameStatus(showCode: Boolean) extends Game{
  private val PARAMETERS: GameParameters = wire[GameParameters]
  private val CODE_LENGTH: Int = PARAMETERS.codeLength

  private val colourHandler: ColourHandler = wire[ColourHandler]
  private val codeFactory: CodeFactory = wire[CodeFactory]
  private val EMPTY_GUESS_RESPONSE_VECTOR = Vector[Guess]().zip(Vector[Response]())
  /**
    * Run one or more games of mastermind, until the player
    * quits.
    */
  override def runGames: Unit = {
    println("Welcome to Mastermind\n\n" +
            "This is a text version of the classic board game Mastermind.\n" +
            "The computer will think of a secret code.\n" +
            s"The code consists of $CODE_LENGTH colored pegs.\n" +
            s"The pegs may be one of ${colourHandler.rawNames.length} colors: ${colourHandler.toString()}.\n" +
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
            s"You have ${PARAMETERS.numberOfGuesses} attempts to guess the answer or you lose the game")

    println("Generating secret code...")
    val secretCode: SecretCode = codeFactory.generateSecretCode
    if (showCode) {
      println("The secret code is " + secretCode.toString())
    }
    guessLoop(EMPTY_GUESS_RESPONSE_VECTOR, secretCode)

    println("Enter Y to play again or anything else to quit")
    print(":>")
    val input = StdIn.readLine().toUpperCase
    input match {
      case "Y" => runGames
      case _ => System.exit(0)
    }
  }

  def guessLoop(guessesAndResponses: Vector[(Guess, Response)], code: SecretCode): Unit = {
    println(s"You have ${PARAMETERS.numberOfGuesses - guessesAndResponses.length} guesses left\n")
    println("What is your next guess?\nType in the characters for your guess and press Enter.")
    print("Enter guess: ")

    val input = StdIn.readLine()
    println()
    //Get a guess wrapped in an option based on the input, it will be empty if input is invalid
    val guessOption = codeFactory.processGuess(input)
    guessOption match {
      case None => guessLoop(guessesAndResponses, code)
      case _ => val guess = guessOption.get
        //Even if input is valid, guess may have been made before
        val uniqueGuessCheck: Boolean = checkUniqueGuess(guess, guessesAndResponses)
        if(!uniqueGuessCheck) {
          println("You've already made that guess")
          guessLoop(guessesAndResponses, code)
        } else {

          //This generates the response from the guess
          val responseHandler: ResponseHandler = wire[ResponseHandler]
          val response: Response = responseHandler.getResponse(guess)

          if(showCode) println(s"${code.toString} Secret Code")
          else println(".... Secret Code")

          //Add the new guess and response to the original vector, and print all made guesses and responses
          val zipped: Vector[(Guess, Response)] = Vector[Guess](guess).zip(Vector[Response](response))
          val newGuesses: Vector[(Guess, Response)] = guessesAndResponses ++ zipped
          newGuesses.foreach(g => println(g._1.toString + " Result: " + g._2.toString))

          //Print the appropriate number of remaining guess spots
          val remainingGuesses = PARAMETERS.numberOfGuesses - newGuesses.length
          for (i <- 0 until remainingGuesses) {
            println("....")
          }
          //Check for exit conditions, win and lose
          if(response.pegs.count(p => p.isInstanceOf[Black]) == CODE_LENGTH) {
            println("\n\n\nYou solved the puzzle! Good job!")
          } else {
            remainingGuesses match {
              case 0 => println("\n\n\nYou have run out of guesses. You lose!")
              case _ => guessLoop(newGuesses, code)
            }
          }
        }


    }

  }
  private def checkUniqueGuess(guess: Guess, guessesAndResponses: Vector[(Guess, Response)]): Boolean = {
    guessesAndResponses.foreach(tuple => if(guess.equals(tuple._1)) return false)
    true
  }
}

