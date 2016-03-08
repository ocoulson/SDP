package ObserverPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public interface Observer {
    void update(String desc);

    void subscribe();

    void unSubscribe();
}
