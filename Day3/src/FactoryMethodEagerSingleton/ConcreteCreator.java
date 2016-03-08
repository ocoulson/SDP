package FactoryMethodEagerSingleton;

/**
 * Created by Oliver Coulson on 19/01/2016.
 */
public class ConcreteCreator implements Creator{

    private static Creator INSTANCE = null;

    private ConcreteCreator() {}

    //Uses eager instantiation - INSTANCE is instantiated when class is loaded
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
