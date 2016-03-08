package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class Chicken extends PizzaDecorator {
    private static final String desc = "Chicken, (15.25)";
    private static final double price = 15.25;

    public Chicken(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + price;
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", " + desc;
    }
}
