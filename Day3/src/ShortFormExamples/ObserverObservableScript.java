package ShortFormExamples;

/**
 * Created by Oliver Coulson on 21/01/2016.
 */
public class ObserverObservableScript {

    public static void main(String[] args) {
        ObserverObservableScript myOne = new ObserverObservableScript();
        myOne.launch();
    }

    public void launch() {
        ObservableExample observable = new ObservableExample(1, "Hello");
        ObserverExample observer = new ObserverExample(observable);


        observable.addObserver(observer);

        observable.setA(3);
        observable.setB("Goodbye");

    }
}
