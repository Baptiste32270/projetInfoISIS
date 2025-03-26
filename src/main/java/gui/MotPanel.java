package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.util.Random;

/**
 * Afficheur pour le mot à deviner dans le jeu du pendu.
 */
@SuppressWarnings("serial")
public class MotPanel extends JPanel {

    private final JLabel displayLabel;
    private final Font font;
    private String motSecret;  // Le mot à deviner
    private String lettresDevinees;  // Les lettres devinées par l'utilisateur

    public MotPanel(Font font) {
        super();
        this.font = font;
        this.displayLabel = new JLabel("", JLabel.CENTER);
        this.lettresDevinees = "";
        initGui();
        choisirMotSecret();  // Choisir un mot aléatoire
    }

    MotPanel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void initGui() {
        displayLabel.setFont(font);
        displayLabel.setBackground(Color.LIGHT_GRAY);
        displayLabel.setOpaque(true);
        this.setLayout(new BorderLayout());

        // Créer une bordure pour l'afficheur
        Border border = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(3, 6, 3, 6)
        );
        displayLabel.setBorder(border);
        this.add(displayLabel, BorderLayout.CENTER);
    }

    /**
     * Choisit un mot aléatoire dans l'énum Dictionnaire.
     */
    private void choisirMotSecret() {
        Dictionnaire[] valeurs = Dictionnaire.values();
        Random random = new Random();
        int index = random.nextInt(valeurs.length);
        motSecret = valeurs[index].toString();
    }

    /**
     * Met à jour l'affichage avec les lettres devinées et les espaces pour celles non devinées.
     * Exemple : "A _ P _ E _" pour le mot "APPLE" avec "A", "P" et "E" devinés.
     */
    public void updateDisplay(String guessedLetter) {
        if (motSecret.contains(guessedLetter)) {
            lettresDevinees += guessedLetter;  // Ajouter la lettre devinée
        }

        StringBuilder displayText = new StringBuilder();

        for (int i = 0; i < motSecret.length(); i++) {
            char letter = motSecret.charAt(i);
            // Si la lettre a été devinée, l'afficher, sinon afficher un underscore (_)
            if (lettresDevinees.indexOf(letter) != -1) {
                displayText.append(letter).append(" ");
            } else {
                displayText.append("_ ").append(" ");
            }
        }

        // Affichage du mot sous forme lisible avec tirets pour les lettres non devinées
        displayLabel.setText(displayText.toString().trim());
    }

    public void reset() {
        this.lettresDevinees = "";
        this.displayLabel.setText("");
        choisirMotSecret();  // Rechoisir un mot aléatoire
    }
}