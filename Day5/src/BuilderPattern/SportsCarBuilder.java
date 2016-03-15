package BuilderPattern;

/**
 * Created by Oliver Coulson on 08/02/2016.
 */
public class SportsCarBuilder implements CarBuilder {

    private Car sports;

    public SportsCarBuilder() {
        this.sports = new Car("Sports");
    }

    @Override
    public void buildBodyStyle() {
        sports.setBodyStyle("2 Door, rear engine, spoiler");
    }

    @Override
    public void buildPower() {
        sports.setPower("500 bhp");
    }

    @Override
    public void buildEngine() {
        sports.setEngine("V8");
    }

    @Override
    public void buildBreaks() {
        sports.setBreaks("Sweet Disc Breaks");
    }

    @Override
    public void buildSeats() {
        sports.setSeats("Bucket-style racing seats, with racing belts");
    }

    @Override
    public void buildWindows() {
        sports.setWindows("Tinted all round");
    }

    @Override
    public void buildFuelType() {
        sports.setFuelType("Rocket Fuel");
    }

    @Override
    public Car getCar() {
        return sports;
    }
}
