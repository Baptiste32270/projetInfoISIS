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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReponsePanelDifficile extends JPanel {
    private JTextField answerField;
    private JButton checkButton;
    private JButton newQuestionButton;
    private final CalculMentalDifficile parentFrame;

    public ReponsePanelDifficile(Font font, CalculMentalDifficile parentFrame) {
        this.parentFrame = parentFrame;
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
                parentFrame.checkAnswer();
            }
        });

        newQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.generateNewQuestionDifficile(); // Supprimé le paramètre booléen
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
