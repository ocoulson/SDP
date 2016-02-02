package BuilderPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public interface CarBuilder {
    String setBodyStyle();
    String setPower();
    String setEngine();
    String setBreaks();
    String setSeats();
    String setWindows();
    String setFuelType();

    Car getCar();
}