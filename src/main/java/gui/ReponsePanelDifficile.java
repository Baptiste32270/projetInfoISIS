/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author rkiekenm
 */
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ReponsePanelDifficile extends JPanel {
    private JTextField answerField;
    private JButton checkButton;
    private JButton newQuestionButton;
    private JButton solutionButton;
    private final CalculMentalDifficile parentFrame;

    public ReponsePanelDifficile(Font font, CalculMentalDifficile parentFrame) {
        this.parentFrame = parentFrame;
        this.setLayout(new GridLayout(2, 1, 5, 5)); // Ajout d'espacement entre les composants
        this.setBorder(new EmptyBorder(10, 10, 10, 10)); // Marge autour du panel

        answerField = new JTextField(10);
        answerField.setFont(font);
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
        checkButton.setMargin(new Insets(5, 5, 5, 5)); // Réduction de la marge interne
        buttonPanel.add(checkButton);

        newQuestionButton = new JButton("Nouveau");
        newQuestionButton.setFont(font);
        newQuestionButton.setMargin(new Insets(5, 5, 5, 5));
        buttonPanel.add(newQuestionButton);
        
        solutionButton = new JButton("Solution");
        solutionButton.setFont(font);
        solutionButton.setMargin(new Insets(5, 5, 5, 5));
        buttonPanel.add(solutionButton);
        
        this.add(buttonPanel);

        // Listeners (inchangés)
        checkButton.addActionListener(e -> parentFrame.checkAnswer());
        newQuestionButton.addActionListener(e -> parentFrame.generateNewQuestionDifficile());
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