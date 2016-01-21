package FactoryMethodLazySingleton;

/**
 * Created by Oliver Coulson on 19/01/2016.
 */

public class ConcreteProduct implements Product {
    private String name;
    private int id;

    public ConcreteProduct(String name, int id) {
        this.name = name;
        this.id = id;
    }


    @Override
    public String toString() {
        return name + " " + id;
    }

    @Override
    public int getID() {
        return id;
    }
}
