package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class NYCOrderParser implements XMLParser {
    @Override
    public String parse() {
        return "NYC Parsing order XML...\nNYC Order XML Message";

    }
}
