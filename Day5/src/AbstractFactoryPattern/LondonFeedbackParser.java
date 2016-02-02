package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class LondonFeedbackParser implements XMLParser {
    @Override
    public String parse() {
        return "London Parsing feedback XML...\nLondon Feedback XML Message";
    }
}
