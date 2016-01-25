package ObserverPattern;

import java.util.List;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class CommentaryObject implements Commentary, Subject {
    private List<Observer> observers;
    private String desc;
    private String subjectDetails;

    public CommentaryObject(List<Observer> observers, String subjectDetails) {
        this.subjectDetails = subjectDetails;
        this.observers = observers;
        desc = "";
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
        notifyObservers();
    }


    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(desc);
        }
    }

    @Override
    public String subjectDetails() {
        return subjectDetails;
    }
}
