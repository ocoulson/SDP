package ShortFormExamples;

/**
 * Created by Oliver Coulson on 21/01/2016.
 */
public interface Interface1 {
    default int add(int a, int b) {
        return a + b;
    }
}
