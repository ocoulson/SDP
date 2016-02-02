package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class AbstractFactoryPatternTest {

        public static void main(String[] args) {
            AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory("NYCFactory");
            XMLParser parser = parserFactory.getParserInstance("NYCORDER");
            String msg = "";
            msg = parser.parse();
            System.out.println(msg);
            System.out.println("************************************");
            parserFactory = ParserFactoryProducer.getFactory("LondonFactory");
            parser = parserFactory.getParserInstance("LondonFEEDBACK");
            msg = parser.parse();
            System.out.println(msg);
        }
}
