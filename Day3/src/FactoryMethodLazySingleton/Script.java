package FactoryMethodLazySingleton;

/**
 * Created by Oliver Coulson on 19/01/2016.
 */
public class Script {
    public static void main(String[] args) {
        Creator myCreator = ConcreteCreator.getInstance();
        Product myProduct = myCreator.newProduct("Durrrp", 1);

        System.out.println(myProduct);
    }
}
