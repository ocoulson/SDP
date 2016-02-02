package BuilderPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class SedanCarBuilder implements CarBuilder {
    private Car car;

    public SedanCarBuilder() {
        car = new Car("Sedan");
        setBodyStyle();
        setBreaks();
        setPower();
        setEngine();
        setFuelType();
        setSeats();
        setWindows();

    }
    @Override
    public void setBodyStyle() {
        car.setBodyStyle("Sleek Sedan");
    }

    @Override
    public void setPower() {
        car.setPower("120 bhp");
    }

    @Override
    public void setEngine() {
        car.setEngine("1.5 cc");
    }

    @Override
    public void setBreaks() {
        car.setBreaks("Standard Break Pads - Rating B");
    }

    @Override
    public void setSeats() {
        car.setSeats("Toasty heated seats");
    }

    @Override
    public void setWindows() {
        car.setWindows("Deep Blue tinted windows");
    }

    @Override
    public void setFuelType() {
        car.setFuelType("Unleaded");
    }

    @Override
    public Car getCar() {
        return car;
    }
}
