package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class Meat extends PizzaDecorator {
    private static final String desc = "Meat, (14.25)";
    private static final double price = 14.25;

    public Meat(Pizza pizza) {
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
