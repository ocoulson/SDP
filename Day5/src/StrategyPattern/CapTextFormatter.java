package StrategyPattern;


/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class CapTextFormatter implements TextFormatter {

    @Override
    public void format(String text) {
        System.out.println(text.toUpperCase());
    }
}
