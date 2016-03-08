package helloworld;

/**
 * Created by Oliver Coulson on 12/01/2016.
 */
public class HelloWorldDecoupled {
    public static void main(String[] args) {
        StandardOutMessageRenderer mr = new StandardOutMessageRenderer();
        HelloWorldMessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
