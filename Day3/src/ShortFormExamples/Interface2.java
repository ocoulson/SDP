package ShortFormExamples;

/**
 * Created by Oliver Coulson on 21/01/2016.
 */
public interface Interface2 {
    default int subtract(int a, int b) {
        return a - b;
    }
}
