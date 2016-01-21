package FactoryMethodLazySingleton;

/**
 * Created by Oliver Coulson on 19/01/2016.
 */
public class Script {
    public static void main(String[] args) {
        Product myProduct = ConcreteCreator.getInstance().newProduct("Durrrp", 1);

        System.out.println(myProduct);
    }
}
