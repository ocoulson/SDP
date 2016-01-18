package HelloWorldDecoupledWithFactory;

import helloworlddecoupledinterface.MessageProvider;
import helloworlddecoupledinterface.MessageRenderer;

/**
 * Created by Oliver Coulson on 15/01/2016.
 */
public class HelloWorldDecoupledWithFactory {
    public static void main(String[] args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();

        mr.setMessageProvider(mp);
        mr.render();
    }
}
