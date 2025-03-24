/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author oguera
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

/**
 * Afficheur pour le mot à deviner dans le jeu du pendu.
 */
@SuppressWarnings("serial")
public class MotPanel extends JPanel {

    private final JLabel displayLabel;
    private final Font font;

    public MotPanel(Font font) {
        super();
        this.font = font;
        this.displayLabel = new JLabel("", JLabel.CENTER);
        initGui();
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
     * Met à jour l'affichage avec les lettres devinées et les espaces pour celles non devinées.
     * Exemple : "A _ P _ E _" pour le mot "APPLE" avec "A", "P" et "E" devinés.
     */
    public void updateDisplay(String wordToGuess, String guessedLetters) {
        StringBuilder displayText = new StringBuilder();

        for (int i = 0; i < wordToGuess.length(); i++) {
            char letter = wordToGuess.charAt(i);
            // Si la lettre a été devinée, l'afficher, sinon afficher un underscore (_)
            if (guessedLetters.indexOf(letter) != -1) {
                displayText.append(letter).append(" ");
            } else {
                displayText.append("_ ").append(" ");
            }
        }

        // Affichage du mot sous forme lisible
        displayLabel.setText(displayText.toString().trim());
    }

    public void reset() {
        this.displayLabel.setText("");
    }
}
