/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author rkiekenm
 */
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class ResultPanel extends JPanel {
    private JLabel resultLabel;

    public ResultPanel(Font font) {
        this.setLayout(new BorderLayout());
        resultLabel = new JLabel(" ");
        resultLabel.setFont(font);
        this.add(resultLabel, BorderLayout.CENTER);
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }
}

