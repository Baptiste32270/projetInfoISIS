package gui;

import javax.swing.*;
import java.awt.Font;

public class LettresButton extends JButton {

    public LettresButton(String text) {
        super(text);
        setProperties();  // Personnalisation
    }

    private void setProperties() {
        setFont(new Font("Arial", Font.BOLD, 20));
        setBorderPainted(true);
    }
}