package SingletonProtectedClass;


/**
 * Created by Oliver Coulson on 21/01/2016.
 */
public class SingletonProtected {

    private static SingletonProtected INSTANCE = new SingletonProtected();

    private SingletonProtected() {

        if (INSTANCE != null) {
            throw new IllegalStateException("Singleton already exists");
        }

    }

    @Override
    public SingletonProtected clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }



}
