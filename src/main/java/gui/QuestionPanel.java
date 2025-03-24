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

public class QuestionPanel extends JPanel {
    private final JLabel questionLabel;

    public QuestionPanel(Font font) {
        questionLabel = new JLabel("Question", JLabel.CENTER);
        questionLabel.setFont(font);
        this.add(questionLabel);
    }

    public void setQuestion(String question) {
        questionLabel.setText(question);
    }
}



