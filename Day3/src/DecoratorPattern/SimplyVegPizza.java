package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class SimplyVegPizza implements Pizza{
    private String desc = "SimplyVegPizza (230)";
    private double price = 230;

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
