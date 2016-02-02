package BuilderPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class SportsCarBuilder implements CarBuilder {
    private Car car;

    public SportsCarBuilder() {
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
        car.setBodyStyle("Sporty-as-f***");
    }

    @Override
    public void setPower() {
        car.setPower("500 bhp");
    }

    @Override
    public void setEngine() {
        car.setEngine("V8 Turbo");
    }

    @Override
    public void setBreaks() {
        car.setBreaks("Sweet Disk Breaks");
    }

    @Override
    public void setSeats() {
        car.setSeats("Racing Bucket Seats");
    }

    @Override
    public void setWindows() {
        car.setWindows("Turbo Electric Shatterproof Rolldown");
    }

    @Override
    public void setFuelType() {
        car.setFuelType("Anything which was once a dinosaur");
    }

    @Override
    public Car getCar() {
        return car;
    }
}
