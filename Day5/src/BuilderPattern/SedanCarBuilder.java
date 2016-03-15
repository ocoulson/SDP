package BuilderPattern;

/**
 * Created by Oliver Coulson on 08/02/2016.
 */
public class SedanCarBuilder implements CarBuilder {

    private Car sedan;

    public SedanCarBuilder() {
        this.sedan = new Car("Sedan");
    }

    @Override
    public void buildBodyStyle() {
        sedan.setBodyStyle("4 Door Saloon");
    }

    @Override
    public void buildPower() {
        sedan.setPower("250 bhp");
    }

    @Override
    public void buildEngine() {
        sedan.setEngine("2 litre");
    }

    @Override
    public void buildBreaks() {
        sedan.setBreaks("Standard breaks");
    }

    @Override
    public void buildSeats() {
        sedan.setSeats("Leather Upholstered, heated");
    }

    @Override
    public void buildWindows() {
        sedan.setWindows("Electric autodown with child lock");
    }

    @Override
    public void buildFuelType() {
        sedan.setFuelType("Unleaded Petrol");
    }

    @Override
    public Car getCar() {
        return sedan;
    }
}
