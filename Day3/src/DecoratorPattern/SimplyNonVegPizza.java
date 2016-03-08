package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class SimplyNonVegPizza implements Pizza {
    private String desc = "SimplyNonVegPizza (350)";
    private double price = 350;


    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
