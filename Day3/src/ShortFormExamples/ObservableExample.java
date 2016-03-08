package ShortFormExamples;

import lombok.Data;

import java.util.Observable;

/**
 * Created by Oliver Coulson on 21/01/2016.
 */
@Data
public class ObservableExample extends Observable {

    private int a;
    private String b;

    public ObservableExample(int a, String b) {
        this.a = a;
        this.b = b;
    }

//    public int getA() {
//        return a;
//    }
//
//    public String getB() {
//        return b;
//    }


    public void setA(int a) {
        this.a = a;
        setChanged();
        notifyObservers();
    }

    public void setB(String b) {
        this.b = b;
        setChanged();
        notifyObservers();
    }
}
