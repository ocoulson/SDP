package lombokTesting;

/**
 * Created by Oliver Coulson on 24/01/2016.
 */
public class LombokTestScript {
    public static void main(String[] args) {
        LombokTest myLT = new LombokTest();

        myLT.setA("Hello");
        System.out.println(myLT.getA());

        myLT.setB(1);
        System.out.println(myLT.getB() * 10);
    }




}
