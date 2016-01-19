package HelloWorldGuiceConfig;

import com.google.inject.name.Named;

/**
 * Created by Oliver Coulson on 12/01/2016.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    private String message = "Hello World!";

    public String getMessage() {
        return message;
    }
}
