package gui;

import javax.swing.*;
import java.awt.*;

public class LettrePanel extends JPanel {

    private final DisplayInterface display;
    private final Font font;

    public LettrePanel(DisplayInterface display, Font font) {
        this.display = display;
        this.font = font;
        initGui();
    }

    LettrePanel() {
        this.display = new DefaultDisplay();
        this.font = new Font("Arial", Font.PLAIN, 14);  // Par défaut
        initGui();
    }
    
    private void initGui() {
        this.setFont(font);
        GridLayout g1 = new GridLayout(2, 9, 3, 3);
        this.setLayout(g1);
        String[] lettres = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        
        for (String value : lettres) {
            LettresButton jb = new LettresButton(value);
            jb.setFont(font);
            jb.addActionListener((e) -> display.append(value));
            this.add(jb);
        }
    }
}