package HelloWorldGuiceConfig;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;


/**
 * Created by Oliver Coulson on 18/01/2016.
 */
public class HelloWorldGuiceConfig {

    private MessageRenderer renderer;
    private MessageProvider provider;

    @Inject
    public HelloWorldGuiceConfig(@Named("renderer") MessageRenderer renderer, @Named("provider") MessageProvider provider) {
        this.renderer = renderer;
        this.provider = provider;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new HelloModule());

        HelloWorldGuiceConfig helloWorld = injector.getInstance(HelloWorldGuiceConfig.class);

        helloWorld.run();
    }

    public void run() {
        //replace this with something in the guice.properties file
        renderer.setMessageProvider(provider);

        renderer.render();
    }
}
