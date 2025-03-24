/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author rkiekenm
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class ResultPanel extends JPanel {
    private final JLabel resultLabel;

    public ResultPanel(Font font) {
        resultLabel = new JLabel("Résultat", JLabel.CENTER);
        resultLabel.setFont(font);
        this.add(resultLabel);
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }
}


