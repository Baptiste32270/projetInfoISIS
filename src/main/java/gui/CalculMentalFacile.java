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
    private final QuestionPanel questionPanel; // Panneau pour afficher la question
    private final ReponsePanelFacile reponsePanel; // Panneau pour entrer la réponse
    private final ResultPanel resultPanel; // Panneau pour afficher le résultat

    private int correctReponse; // Stocke la réponse correcte

    public CalculMentalFacile(int fontSize, JFrame frame) {
        Font font = new Font("Serif", Font.BOLD, fontSize); // Définition de la police de caractère

        // Initialisation des panneaux avec la police définie
        this.questionPanel = new QuestionPanel(font);
        this.reponsePanel = new ReponsePanelFacile(font, this);
        this.resultPanel = new ResultPanel(font);

        initGui(); // Configuration de l'interface graphique
        frame.setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        generateNewQuestionFacile(); // Génère une première question
    }
    
    //Méthode qui configure notre interface
    private void initGui() {
        this.setLayout(new BorderLayout(5, 5)); // Définit un layout avec marges entre les composants

        // Ajout des panneaux dans la fenêtre
        this.add(questionPanel, BorderLayout.NORTH); // Panneau de question en haut
        this.add(reponsePanel, BorderLayout.CENTER); // Panneau de réponse au centre
        this.add(resultPanel, BorderLayout.SOUTH); // Panneau de résultat en bas
    }

    public void generateNewQuestionFacile() {
        Random rand = new Random(); // Création d'un objet Random pour générer des nombres aléatoires
        int num1 = rand.nextInt(10) + 1; // Génère un nombre aléatoire entre 1 et 10
        int num2 = rand.nextInt(10) + 1; // Génère un autre nombre aléatoire entre 1 et 10
        String question; // Stocke la question générée
        int operation = rand.nextInt(2); // Génère un nombre entre 0 et 1 pour choisir une opération

        if (operation == 0) { // Addition
            question = num1 + " + " + num2 + " = ?"; // Formule la question d'addition
            correctReponse = num1 + num2; // Calcul de la réponse correcte (addition)
        } else { // Soustraction
            // Si num1 est plus petit que num2, on les inverse pour éviter des résultats négatifs
            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            question = num1 + " - " + num2 + " = ?"; // Formule la question de soustraction
            correctReponse = num1 - num2; // Calcul de la réponse correcte (soustraction)
        }

        questionPanel.setQuestion(question); // Met à jour l'affichage de la question
        reponsePanel.clearAnswer(); // Efface la réponse précédente
        resultPanel.setResult("Résultat"); // Réinitialise l'affichage du résultat à "Résultat"
        resultPanel.setCorrectReponse(String.valueOf(correctReponse)); // Définit la réponse correcte dans ResultPanel
    }

    public void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(reponsePanel.getAnswer()); // Récupère la réponse entrée par l'utilisateur
            if (userAnswer == correctReponse) { // Vérifie si la réponse de l'utilisateur est correcte
                resultPanel.setResult("Correct !"); // Affiche "Correct !" si la réponse est juste
            } else {
                resultPanel.setResult("Faux, essayez encore !"); // Message d'erreur si la réponse est fausse
            }
        } catch (NumberFormatException e) { // Gestion des erreurs si l'utilisateur n'entre pas un nombre
            resultPanel.setResult("Veuillez entrer un nombre !");
        }
    }
    
    // Méthode pour afficher la solution
    public void showSolution() {
        reponsePanel.clearAnswer(); // Efface la réponse actuelle
        reponsePanel.setAnswer(String.valueOf(correctReponse)); // Affiche la réponse correcte
        resultPanel.setResult("Voici la solution !"); // Affiche un message indiquant la solution
    }
}
