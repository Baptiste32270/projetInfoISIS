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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnswerPanel extends JPanel {
    private JTextField answerField;
    private JButton checkButton;
    private JButton newQuestionButton;
    private final CalculMentalFrame parentFrame;

    public AnswerPanel(Font font, CalculMentalFrame parentFrame) {
        this.parentFrame = parentFrame;  // Assure-toi que la référence à la fenêtre principale est bien passée ici
        this.setLayout(new BorderLayout());

        answerField = new JTextField(10);
        answerField.setFont(font);
        this.add(answerField, BorderLayout.CENTER);

        checkButton = new JButton("Vérifier");
        checkButton.setFont(font);
        this.add(checkButton, BorderLayout.EAST);

        newQuestionButton = new JButton("Nouveau");
        newQuestionButton.setFont(font);
        this.add(newQuestionButton, BorderLayout.SOUTH);

        // Ajout des écouteurs d'événements
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.checkAnswer();  // Appelle la méthode de vérification dans la fenêtre principale
            }
        });

        newQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.generateNewQuestion(true);  // Appelle la méthode pour générer une nouvelle question, difficulté difficile
            }
        });
    }

    public String getAnswer() {
        return answerField.getText();
    }

    public void clearAnswer() {
        answerField.setText("");
    }
}
