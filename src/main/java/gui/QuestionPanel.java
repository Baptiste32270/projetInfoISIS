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

public class QuestionPanel extends JPanel {
    private JLabel questionLabel;

    public QuestionPanel(Font font) {
        this.setLayout(new BorderLayout());
        questionLabel = new JLabel("Quel est le résultat ?");
        questionLabel.setFont(font);
        this.add(questionLabel, BorderLayout.CENTER);
    }

    public void setQuestion(String question) {
        questionLabel.setText(question);
    }
}


