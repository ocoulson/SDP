package forecast

/**
  * Created by Oliver Coulson on 12/02/2016.
  */
import atomicscala.src.com.atomicscala.AtomicTest._

object MyForecastTest extends App {
  forecast(100) is "Sunny"
  forecast(80) is "Mostly Sunny"
  forecast(50) is "Partly Sunny"
  forecast(20) is "Mostly Sunny"
  forecast(0) is "Cloudy"
  forecast(15) is "Unknown"
  def forecast(temp: Int): String = {
    temp match {
      case 100 => return "Sunny"
      case 80 => return "Mostly Sunny"
      case 50 => return "Partly Sunny"
      case 20 => return "Mostly Sunny"
      case 0 => return "Cloudy"
      case _ => return "Unknown"

    }
  }
  var sunnyData= Vector(100, 80, 50, 20, 0)



  for (int: Int <- sunnyData) {
    forecast(int)
  }
}


