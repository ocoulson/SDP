package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class Spinach extends PizzaDecorator {
    private static final String desc = "Spinach, (7.92)";
    private static final double price = 7.92;

    public Spinach(Pizza pizza) {
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
