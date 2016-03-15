package StrategyPattern;

/**
 * Created by Oliver Coulson on 02/02/2016.
 */
public class TextEditor {
    private TextFormatter formatter;

    public TextEditor(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public void publishText(String text) {
        formatter.format(text);
    }
}
