package HelloWorldWithSpringDIXMLFile;

import helloworlddecoupledinterface.MessageRenderer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Oliver Coulson on 18/01/2016.
 */
public class HelloWorld {
    public static void main(String[] args) {
        BeanFactory factory = getBeanFactory();

        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }

    private static BeanFactory getBeanFactory() {

        BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
        return factory;
    }
}
