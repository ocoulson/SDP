package ShortFormExamples;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by Oliver Coulson on 21/01/2016.
 */
public class ObserverExample implements Observer {


    private ObservableExample observable = null;


    public ObserverExample(ObservableExample observable) {
        this.observable = observable;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == observable) {
            System.out.println(observable.getA()+ " " + observable.getB());
        }
    }

    public void setObservable(ObservableExample observable) {
        this.observable = observable;
    }
}
