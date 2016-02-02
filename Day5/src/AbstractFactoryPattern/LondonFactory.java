package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class LondonFactory implements AbstractParserFactory {

    private XMLParser xmlParser;

    @Override
    public XMLParser getParserInstance(String parserType) {
        if (parserType.equals("LondonORDER")) {
            xmlParser = new LondonOrderParser();
        } else if(parserType.equals("LondonFEEDBACK")) {
            xmlParser = new LondonFeedbackParser();
        }
        return xmlParser;
    }
}
