package ShortFormExamples;

/**
 * Created by Oliver Coulson on 21/01/2016.
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy(){}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }

        return instance;
    }
}
