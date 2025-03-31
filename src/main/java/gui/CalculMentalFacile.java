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
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculMentalFacile extends JPanel {
    private final QuestionPanel questionPanel;
    private final ReponsePanelFacile reponsePanel;
    private final ResultPanel resultPanel;

    private int correctReponse;

    public CalculMentalFacile(int fontSize, JFrame frame) {
        Font font = new Font("Serif", Font.BOLD, fontSize);

        // Initialisation des panneaux
        this.questionPanel = new QuestionPanel(font);
        this.reponsePanel = new ReponsePanelFacile(font, this);
        this.resultPanel = new ResultPanel(font);

        initGui();
        frame.setSize(400, 300);  // Ajuster la taille de la fenêtre
        frame.setLocationRelativeTo(null);
        generateNewQuestionFacile();
    }

    private void initGui() {
        this.setLayout(new BorderLayout(5, 5)); // Ajout de l'espacement entre les composants

        // Ajout des panneaux
        this.add(questionPanel, BorderLayout.NORTH);
        this.add(reponsePanel, BorderLayout.CENTER);
        this.add(resultPanel, BorderLayout.SOUTH);
    }

    public void generateNewQuestionFacile() {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        String question;
        int operation = rand.nextInt(2);

        if (operation == 0) {
            question = num1 + " + " + num2 + " = ?";
            correctReponse = num1 + num2;
        } else { // Soustraction
            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            question = num1 + " - " + num2 + " = ?";
            correctReponse = num1 - num2;
        }

        questionPanel.setQuestion(question);
        reponsePanel.clearAnswer();
        resultPanel.setResult("Résultat"); // Remettre un texte de base
        resultPanel.setCorrectReponse(String.valueOf(correctReponse)); // Définir la réponse correcte dans ResultPanel
    }

    public void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(reponsePanel.getAnswer());
            if (userAnswer == correctReponse) {
                resultPanel.setResult("Correct !");
            } else {
                resultPanel.setResult("Faux, essayez encore !");
            }
        } catch (NumberFormatException e) {
            resultPanel.setResult("Veuillez entrer un nombre valide.");
        }
    }
}
