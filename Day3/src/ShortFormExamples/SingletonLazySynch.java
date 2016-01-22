package ShortFormExamples;

/**
 * Created by Oliver Coulson on 21/01/2016.
 */
public class SingletonLazySynch {
    private static volatile SingletonLazySynch instance;

    private SingletonLazySynch(){}

    public static SingletonLazySynch getInstance() {
        if (instance == null) {
            synchronized (SingletonLazySynch.class) {
                if (instance == null) {
                    instance = new SingletonLazySynch();
                }
            }

        }

        return instance;
    }
}
