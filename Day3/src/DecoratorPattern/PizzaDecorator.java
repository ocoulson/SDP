package DecoratorPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public abstract class PizzaDecorator implements Pizza {
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc();
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }

}
