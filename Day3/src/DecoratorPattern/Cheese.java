package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class Cheese extends PizzaDecorator {
    private final String desc = "Cheese, (20.72)";
    private final double price = 20.72;

    public Cheese(Pizza pizza) {
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
