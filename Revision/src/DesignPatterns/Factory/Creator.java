package DesignPatterns.Factory;

/**
 * Created by Oliver Coulson on 04/06/2016.
 */
public interface Creator {
    default Product newProduct() {
        return new ConcreteProduct();
    }

}
