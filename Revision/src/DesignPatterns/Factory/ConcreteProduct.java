package DesignPatterns.Factory;

/**
 * Created by Oliver Coulson on 04/06/2016.
 */
public class ConcreteProduct implements Product {
    @Override
    public void use() {
        System.out.println("Using product");
    }
}
