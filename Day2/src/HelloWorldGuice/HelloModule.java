package HelloWorldGuice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Oliver Coulson on 18/01/2016.
 */
public class HelloModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(MessageRenderer.class).to(StandardOutMessageRenderer.class);
        bind(MessageProvider.class).to(HelloWorldMessageProvider.class);

//        try{
//            Properties props = new Properties();
//            props.load(new FileReader("./Day2/src/HelloWorldGuice/guice.properties"));
//            Names.bindProperties(binder(), props);
//        } catch(FileNotFoundException ex) {
//            ex.printStackTrace();`
//        } catch(IOException ex) {
//            ex.printStackTrace();
//        }

    }
}
