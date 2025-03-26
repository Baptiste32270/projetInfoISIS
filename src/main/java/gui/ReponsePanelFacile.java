/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReponsePanelFacile extends JPanel {
    private JTextField answerField;
    private JButton checkButton;
    private JButton newQuestionButton;
    private final CalculMentalFacile parentFrame;

    public ReponsePanelFacile(Font font, CalculMentalFacile parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new BorderLayout());

        answerField = new JTextField(10);
        answerField.setFont(font);
        this.add(answerField, BorderLayout.CENTER);
        
        answerField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Empêche la saisie d'un caractère non numérique
                }
            }
        });

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
                parentFrame.generateNewQuestionFacile(); // Supprimé le paramètre booléen
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
