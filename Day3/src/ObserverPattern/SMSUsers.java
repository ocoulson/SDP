package ObserverPattern;

/**
 * Created by Oliver Coulson on 25/01/2016.
 */
public class SMSUsers implements Observer {
    private Subject subject;
    private String details;

    public SMSUsers(Subject subject, String details) {
        this.subject = subject;
        this.details = details;
    }

    @Override
    public void update(String desc) {
        System.out.println(details + " :" + subject.subjectDetails()+ " :" +  desc);
    }

    @Override
    public void subscribe() {
        subject.subscribeObserver(this);
    }

    @Override
    public void unSubscribe() {
        subject.unSubscribeObserver(this);
    }
}
