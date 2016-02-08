package BuilderPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public interface CarBuilder {

    void buildBodyStyle();
    void buildPower();
    void buildEngine();
    void buildBreaks();
    void buildSeats();
    void buildWindows();
    void buildFuelType();

    Car getCar();
}