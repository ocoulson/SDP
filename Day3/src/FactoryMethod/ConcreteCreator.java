package FactoryMethod;

/**
 * Created by Oliver Coulson on 19/01/2016.
 */
public class ConcreteCreator implements Creator{
    public static Creator INSTANCE = null;

    private ConcreteCreator() {}

    static {
        INSTANCE = new ConcreteCreator();
    }

    @Override
    public Product newProduct(String name, int id) {
        return new ConcreteProduct(name, id);
    }

    public static Creator getInstance() {
        return INSTANCE;
    }
}
