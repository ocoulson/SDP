package FactoryMethodLazySingleton;

/**
 * Created by Oliver Coulson on 19/01/2016.
 */
public class ConcreteCreator implements Creator {
    private static Creator INSTANCE = null;

    private ConcreteCreator() {}

    @Override
    public Product newProduct(String name, int id) {
        return new ConcreteProduct(name, id);
    }

    public static Creator getInstance() {

        //Uses lazy instantiation - INSTANCE is instantiated when getInstance() is called.
        if (INSTANCE == null) {

            synchronized (ConcreteCreator.class) {

                if (INSTANCE == null) {

                    INSTANCE = new ConcreteCreator();
                }

            }

        }

        return INSTANCE;
    }
}
