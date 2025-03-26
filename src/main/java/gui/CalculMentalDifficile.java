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
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

public class CalculMentalDifficile extends JFrame {
    private final QuestionPanel questionPanel;
    private final ReponsePanelDifficile reponsePanel;
    private final ResultPanel resultPanel;

    private int correctReponse;

    public CalculMentalDifficile() {
        this("Calcul Mental - Difficile", 18);
    }

    public CalculMentalDifficile(String title, int fontSize) {
        super(title);
        Font font = new Font("Serif", Font.BOLD, fontSize);
        this.setFont(font);

        // Initialisation des panneaux
        this.questionPanel = new QuestionPanel(font);
        this.reponsePanel = new ReponsePanelDifficile(font, this);
        this.resultPanel = new ResultPanel(font);

        initGui();
        generateNewQuestionDifficile();
    }

    private void initGui() {
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout(5, 5));

        root.add(questionPanel, BorderLayout.NORTH);
        root.add(reponsePanel, BorderLayout.CENTER);
        root.add(resultPanel, BorderLayout.SOUTH);

        this.add(root);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void generateNewQuestionDifficile() {
        Random rand = new Random();
        int num1, num2;
        String question;

        int operation = rand.nextInt(3);
        if (operation == 0) { // Addition
            num1 = rand.nextInt(900) + 100; // Nombre entre 100 et 999
            num2 = rand.nextInt(900) + 100;
            question = num1 + " + " + num2 + " = ?";
            correctReponse = num1 + num2;
        } else if (operation == 1) { // Soustraction
            num1 = rand.nextInt(900) + 100;
            num2 = rand.nextInt(900) + 100;
            question = num1 + " - " + num2 + " = ?";
            correctReponse = num1 - num2;
        } else { // Multiplication
            num1 = rand.nextInt(9) + 1; // Nombre entre 1 et 9
            num2 = rand.nextInt(9) + 1;
            question = num1 + " * " + num2 + " = ?";
            correctReponse = num1 * num2;
        }

        questionPanel.setQuestion(question);
        reponsePanel.clearAnswer();
        resultPanel.setResult(" ");
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

    public static void main(String[] args) {
        new CalculMentalDifficile();
    }
}

