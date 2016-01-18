package HelloWorldDecoupledWithFactory;

import helloworlddecoupledinterface.MessageProvider;
import helloworlddecoupledinterface.MessageRenderer;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Oliver Coulson on 15/01/2016.
 */
public class MessageSupportFactory {

    private static MessageSupportFactory instance = null;

    private Properties props = null;
    private MessageRenderer renderer = null;
    private MessageProvider provider = null;

    private MessageSupportFactory() {
        props = new Properties();

        try {
            props.load(new FileInputStream("/Users/olliecoulson/Documents/IntelliJProjects/MSc/SDP/Day2/src/HelloWorldDecoupledWithFactory/bean.properties"));

            //Get implementation classes
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Static code block
    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}
