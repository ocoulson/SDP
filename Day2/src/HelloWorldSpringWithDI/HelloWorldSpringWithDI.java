package HelloWorldSpringWithDI;

import helloworlddecoupledinterface.MessageRenderer;

import org.springframework.beans.factory.BeanFactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Oliver Coulson on 18/01/2016.
 */
public class HelloWorldSpringWithDI {
    public static void main(String[] args) {

        BeanFactory factory = getBeanFactory();

        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");

        mr.render();

    }

    private static BeanFactory getBeanFactory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(factory);

        Properties props = new Properties();

        try {
            props.load(new FileInputStream("/Users/olliecoulson/Documents/IntelliJProjects" +
                    "/MSc/SDP/Day2/src/HelloWorldSpringWithDI/beans.properties"));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        reader.registerBeanDefinitions(props);
        return factory;

    }
}
