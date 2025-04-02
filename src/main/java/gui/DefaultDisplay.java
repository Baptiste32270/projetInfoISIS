package gui;

public class DefaultDisplay implements DisplayInterface {

    private String text;

    public DefaultDisplay() {
        text = "";
    }

    @Override
    public void reset() {
        text = "";
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void append(String text) {
        this.text += text;
    }
}
