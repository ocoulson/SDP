
import java.util.Scanner;

/**
 * Created by Oliver Coulson on 05/01/2016.
 */
public class Create {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of Class: ");
        String str = sc.next();


        try {
            Class cl = Class.forName(str);
            Object o = cl.newInstance();
            System.out.println(o);

            A a = new A();
            Class cl2 = a.getClass();
            Object o2 = cl2.newInstance();
            System.out.println(o2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}

class A {
    @Override
    public String toString() {
        return "I am an " + getClass().getName();
    }
}
