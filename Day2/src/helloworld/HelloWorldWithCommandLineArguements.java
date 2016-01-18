package helloworld;

/**
 * Created by Oliver Coulson on 12/01/2016.
 */
public class HelloWorldWithCommandLineArguements {

    public static void main(String[] args) {
        if(args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello World!");
        }
    }
}
