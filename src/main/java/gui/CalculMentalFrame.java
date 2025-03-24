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

public class CalculMentalFrame extends JFrame {
    private final QuestionPanel questionPanel;
    private final AnswerPanel answerPanel;
    private final ResultPanel resultPanel;

    private int correctAnswer;

    public CalculMentalFrame() {
        this("Jeu de calcul mental", 18);
    }

    public CalculMentalFrame(String title, int fontSize) {
        super(title);
        Font font = new Font("Serif", Font.BOLD, fontSize);
        this.setFont(font);

        // Initialisation des panneaux
        this.questionPanel = new QuestionPanel(font);
        this.answerPanel = new AnswerPanel(font, this);  // Passer la fenêtre principale ici
        this.resultPanel = new ResultPanel(font);

        initGui();
    }

    private void initGui() {
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout(5, 5));

        // Ajout des panneaux dans la fenêtre
        root.add(questionPanel, BorderLayout.NORTH);
        root.add(answerPanel, BorderLayout.CENTER);
        root.add(resultPanel, BorderLayout.SOUTH);

        this.add(root);
        this.pack();
        this.setLocationRelativeTo(null);  // Centrer la fenêtre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void generateNewQuestion() {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int operation = rand.nextInt(2);

        String question;
        if (operation == 0) {
            question = num1 + " + " + num2 + " = ?";
            correctAnswer = num1 + num2;
        } else {
            question = num1 + " - " + num2 + " = ?";
            correctAnswer = num1 - num2;
        }

        questionPanel.setQuestion(question);
        answerPanel.clearAnswer();
        resultPanel.setResult(" ");
    }

    public void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(answerPanel.getAnswer());
            if (userAnswer == correctAnswer) {
                resultPanel.setResult("Correct !");
            } else {
                resultPanel.setResult("Faux, essayez encore !");
            }
        } catch (NumberFormatException e) {
            resultPanel.setResult("Veuillez entrer un nombre valide.");
        }
    }

    public static void main(String[] args) {
        new CalculMentalFrame();
    }
}
