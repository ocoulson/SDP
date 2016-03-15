package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class NYCFeedbackParser implements XMLParser {
    @Override
    public String parse() {
        return "NYC Parsing feedback XML...\nNYC Feedback XML Message";
    }
}
