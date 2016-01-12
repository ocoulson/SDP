package helloworlddecoupledinterface;

import helloworld.HelloWorldMessageProvider;
import helloworld.MessageProvider;
import helloworld.MessageRenderer;
import helloworld.StandardOutMessageRenderer;

/**
 * Created by Oliver Coulson on 12/01/2016.
 */
public class HelloWorldDecoupledInterface {
    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
