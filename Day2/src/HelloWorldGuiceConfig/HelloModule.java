package HelloWorldGuiceConfig;

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
        Properties props = new Properties();
        try{
            props.load(new FileReader("./Day2/src/HelloWorldGuiceConfig/guice.properties"));
            Names.bindProperties(binder(), props);
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(props);

    }
}
