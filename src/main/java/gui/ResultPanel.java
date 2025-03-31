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
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class ResultPanel extends JPanel {
    private final JLabel resultLabel;
    private String correctReponse; // Réponse correcte
    

    public ResultPanel(Font font) {
        resultLabel = new JLabel("Résultat", JLabel.CENTER);
        resultLabel.setFont(font);
        this.setLayout(new BorderLayout());
        this.add(resultLabel, BorderLayout.CENTER); // Placer le JLabel au centre
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }

    public void setCorrectReponse(String correctReponse) {
        this.correctReponse = correctReponse; // Setter pour définir la réponse correcte
    }

    public String getCorrectReponse() {
        return correctReponse;
    }
}

