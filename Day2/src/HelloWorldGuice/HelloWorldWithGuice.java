package HelloWorldGuice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;



/**
 * Created by Oliver Coulson on 18/01/2016.
 */
public class HelloWorldWithGuice {
    private MessageRenderer renderer;
    private MessageProvider provider;

    @Inject
    public HelloWorldWithGuice(MessageRenderer renderer, MessageProvider provider) {
        this.renderer = renderer;
        this.provider = provider;
        this.renderer.setMessageProvider(this.provider);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new HelloModule());

        HelloWorldWithGuice helloWorld = injector.getInstance(HelloWorldWithGuice.class);

        helloWorld.run();
    }

    public void run() {
        renderer.render();
    }
}
