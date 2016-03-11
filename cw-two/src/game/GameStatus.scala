package game

import handlers.{CodeFactory, ColourHandler}
import com.softwaremill.macwire._

/**
  * Created by Oliver Coulson and George Shiangoli on 11/03/2016.
  */
class GameStatus(showCode: Boolean) extends Game{
  private val CODE_LENGTH: Int = 4
  private val NUMBER_OF_GUESSES = 12

  private val colourHandler = wire[ColourHandler]

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

    gameLoop()
  }

  def gameLoop(): Unit = {
    val size = CODE_LENGTH
    val codeFactory = new CodeFactory(size)//wire[CodeFactory]
    println("Generating secret code...")
    val secretCode: SecretCode = codeFactory.generateSecretCode
    if (showCode) {
      println("The secret code is " + secretCode.toString())
    }

  }
}

