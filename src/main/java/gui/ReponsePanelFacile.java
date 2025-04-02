/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ReponsePanelFacile extends JPanel {
    private JTextField answerField;
    private JButton checkButton;
    private JButton newQuestionButton;
    private JButton solutionButton;
    private final CalculMentalFacile parentFrame;

    public ReponsePanelFacile(Font font, CalculMentalFacile parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Utilisation de BoxLayout pour centrer verticalement
        this.setBorder(new EmptyBorder(10, 10, 10, 10)); // Marge autour du panel

        // Création et configuration du champ de texte
        answerField = new JTextField(10);
        answerField.setFont(font);
        answerField.setAlignmentX(CENTER_ALIGNMENT); // Centrer le champ de texte
        answerField.setPreferredSize(new Dimension(200, 30)); // Réduire la taille du champ de texte
        answerField.setMaximumSize(new Dimension(200, 30)); // Assurer que le champ de texte ne dépasse pas cette taille
        this.add(answerField);

        answerField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 0)); // 10px d'espace horizontal entre les boutons
        buttonPanel.setBorder(new EmptyBorder(5, 0, 0, 0)); // Marge au-dessus des boutons

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
        
        this.add(buttonPanel);

        // Listeners (inchangés)
        checkButton.addActionListener(e -> parentFrame.checkAnswer());
        newQuestionButton.addActionListener(e -> parentFrame.generateNewQuestionFacile());
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