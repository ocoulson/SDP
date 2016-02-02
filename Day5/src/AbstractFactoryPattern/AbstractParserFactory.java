package AbstractFactoryPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public interface AbstractParserFactory {
    public XMLParser getParserInstance(String parserType);

}
