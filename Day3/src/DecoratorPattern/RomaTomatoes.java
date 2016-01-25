package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class RomaTomatoes extends PizzaDecorator {
    private static final String desc = "Roma Tomatoes, (5.20)";
    private static final double price = 5.20;

    public RomaTomatoes(Pizza pizza) {
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
