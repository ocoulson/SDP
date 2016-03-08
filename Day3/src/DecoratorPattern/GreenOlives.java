package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class GreenOlives extends PizzaDecorator {
    private static final String desc = "Green Olives, (5.47)";
    private static final double price = 5.47;

    public GreenOlives(Pizza pizza) {
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
