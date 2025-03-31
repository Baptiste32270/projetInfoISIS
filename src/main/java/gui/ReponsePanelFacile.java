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
    private JButton solutionButton;
    private final CalculMentalFacile parentFrame;

    public ReponsePanelFacile(Font font, CalculMentalFacile parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new BorderLayout(10, 10)); // Ajout de l'espacement entre les composants

        answerField = new JTextField(10);
        answerField.setFont(font);
        this.add(answerField, BorderLayout.NORTH);  // Placer le champ de texte en haut

        answerField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Empêche la saisie d'un caractère non numérique
                }
            }
        });

        // Panel pour regrouper les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout(5, 5)); // Ajouter des marges

        checkButton = new JButton("Vérifier");
        checkButton.setFont(font);
        buttonPanel.add(checkButton, BorderLayout.WEST);

        newQuestionButton = new JButton("Nouveau");
        newQuestionButton.setFont(font);
        buttonPanel.add(newQuestionButton, BorderLayout.CENTER);

        solutionButton = new JButton("Solution");
        solutionButton.setFont(font);
        buttonPanel.add(solutionButton, BorderLayout.EAST);

        this.add(buttonPanel, BorderLayout.CENTER); // Ajouter le panel des boutons au centre

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

        solutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPanel.setResult("La réponse est : " + resultPanel.getCorrectReponse());
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
