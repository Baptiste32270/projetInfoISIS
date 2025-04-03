/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.EmptyBorder;

public class ReponsePanelFacile extends JPanel {
    private JTextField answerField;
    private JButton checkButton;
    private JButton newQuestionButton;
    private JButton solutionButton;
    private final CalculMentalFacile parentFrame;

    public ReponsePanelFacile(Font font, CalculMentalFacile parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new BorderLayout(5, 5)); // Utilisation de BorderLayout pour séparer les zones

        // Création et configuration du champ de texte (réduit)
        answerField = new JTextField(10); // Champ de texte de largeur réduite
        Font biggerFont = font.deriveFont(font.getSize() + 5f); // Augmente la taille de la police de 5 points
        answerField.setFont(biggerFont);
        answerField.setPreferredSize(new Dimension(100, 30)); // Taille du champ de texte
        answerField.setMaximumSize(new Dimension(100, 30)); // Limiter la taille à cette dimension
        answerField.setHorizontalAlignment(JTextField.CENTER); // Centrer le texte à l'intérieur du champ
        this.add(answerField, BorderLayout.CENTER); // Le champ de texte est au centre
        
        answerField.requestFocusInWindow();

        // Empêcher l'utilisateur de saisir autre chose que des chiffres
        answerField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        // Sous-panel pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 0)); // 10px d'espace horizontal entre les boutons
        buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0)); // Marge au-dessus et au-dessous des boutons

        // Création des boutons avec taille ajustée
        checkButton = new JButton("Vérifier");
        checkButton.setFont(font);
        checkButton.setPreferredSize(new Dimension(100, 40)); // Taille réduite des boutons
        buttonPanel.add(checkButton);

        newQuestionButton = new JButton("Nouveau");
        newQuestionButton.setFont(font);
        newQuestionButton.setPreferredSize(new Dimension(100, 40)); // Taille réduite des boutons
        buttonPanel.add(newQuestionButton);

        solutionButton = new JButton("Solution");
        solutionButton.setFont(font);
        solutionButton.setPreferredSize(new Dimension(100, 40)); // Taille réduite des boutons
        buttonPanel.add(solutionButton);

        this.add(buttonPanel, BorderLayout.SOUTH); // Ajouter le panel des boutons en bas
        
        // Listeners (inchangés)
        checkButton.addActionListener(e -> parentFrame.checkAnswer());
        newQuestionButton.addActionListener(e -> {
            parentFrame.generateNewQuestionFacile();  // Génère une nouvelle question
            answerField.requestFocusInWindow(); // Focus automatique sur le champ de texte
        });
        solutionButton.addActionListener(e -> parentFrame.showSolution());
    }

    public String getAnswer() {
        return answerField.getText();
    }

    public void clearAnswer() {
        answerField.setText("");
    }

    public void setAnswer(String answer) {
        answerField.setText(answer);
    }
}
