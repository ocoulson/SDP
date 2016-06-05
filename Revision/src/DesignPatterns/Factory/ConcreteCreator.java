package DesignPatterns.Factory;

/**
 * Created by Oliver Coulson on 04/06/2016.
 */
public class ConcreteCreator implements Creator{
    private Product product;


    private ConcreteCreator() {
        product = new ConcreteProduct();
    }

    @Override
    public Product newProduct() {
        return product;
    }
}
