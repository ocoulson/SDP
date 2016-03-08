package HelloWorldWithSpringDIXMLFile;

/**
 * Created by Oliver Coulson on 12/01/2016.
 */
public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();

}
