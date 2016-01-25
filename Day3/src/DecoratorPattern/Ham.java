package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class Ham extends PizzaDecorator {
    private static final String desc = "Ham, (18.12)";
    private static final double price = 18.12;

    public Ham(Pizza pizza) {
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
