package BuilderPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public interface CarBuilder {
    void setBodyStyle();
    void setPower();
    void setEngine();
    void setBreaks();
    void setSeats();
    void setWindows();
    void setFuelType();

    Car getCar();
}