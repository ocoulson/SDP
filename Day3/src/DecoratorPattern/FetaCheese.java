package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class FetaCheese extends PizzaDecorator {
    private static final String desc = "FetaCheese, (21.50)";
    private static final double price = 21.50;

    public FetaCheese(Pizza pizza) {
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
