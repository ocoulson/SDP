package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class ParserFactoryProducer {

    private static AbstractParserFactory parser;


    public static AbstractParserFactory getFactory(String name) {
        if (name.equals("NYCFactory")) {
            parser = new NYCFactory();

        } else if (name.equals("LondonFactory")) {
            parser = new LondonFactory();

        }
        return parser;
    }
}
