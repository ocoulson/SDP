package ObserverPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public interface Subject {
    void subscribeObserver(Observer observer);

    void unSubscribeObserver(Observer observer);

    void notifyObservers();

    String subjectDetails();
}
