package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class NYCFactory implements AbstractParserFactory {

    private XMLParser xmlParser;

    @Override
    public XMLParser getParserInstance(String parserType) {
        if (parserType.equals("NYCORDER")) {
            xmlParser = new NYCOrderParser();
        } else if(parserType.equals("NYCFEEDBACK")) {
            xmlParser = new NYCFeedbackParser();
        }
        return xmlParser;
    }
}
