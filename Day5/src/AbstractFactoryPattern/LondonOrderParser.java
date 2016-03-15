package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class LondonOrderParser implements XMLParser {
    @Override
    public String parse() {
        return "London Parsing order XML...\nLondon Order XML Message";
    }
}
