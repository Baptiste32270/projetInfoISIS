/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author oguera
 */
@SuppressWarnings("serial")
public class LettrePanel extends JPanel {
    
    private final DisplayInterface display;
    private final Font font;

    public LettrePanel(DisplayInterface display, Font font) {
        this.display = display;
        this.font = font;
        initGui();
    }

    private void initGui() {
    this.setFont(font);
        GridLayout g1 = new GridLayout(2,2,3,3);
        this.setLayout(g1);
        String[] lettres = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        for (String value : lettres) {
            LettresButton jb = new LettresButton(value);
            jb.setFont(font);
            jb.addActionListener((e)->{
                display.append(value);
            });
        
        this.add(jb);
    }
    }
   
}
