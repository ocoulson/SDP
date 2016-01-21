package FactoryMethodEagerSingleton;

/**
 * Created by Oliver Coulson on 19/01/2016.
 */
public interface Creator {
    
    default Product newProduct(String name, int id) {

        return new ConcreteProduct(name, id);
    }
}
