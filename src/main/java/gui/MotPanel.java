package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.util.Random;

public class MotPanel extends JPanel {

    private final JLabel displayLabel;
    private final Font font;
    private String motSecret;
    private String lettresDevinees;

    public MotPanel(Font font) {
        super();
        this.font = font;
        this.displayLabel = new JLabel("", JLabel.CENTER);
        this.lettresDevinees = "";
        initGui();
        choisirMotSecret();  // Choisir un mot aléatoire
    }

    MotPanel() {
        super();
        this.font = new Font("Arial", Font.PLAIN, 24);  // Par défaut
        this.displayLabel = new JLabel("", JLabel.CENTER);
        this.lettresDevinees = "";
        initGui();
        choisirMotSecret();  // Choisir un mot aléatoire
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

    private void choisirMotSecret() {
        Dictionnaire[] valeurs = Dictionnaire.values();
        Random random = new Random();
        int index = random.nextInt(valeurs.length);
        motSecret = valeurs[index].toString();
    }

    public void updateDisplay(String guessedLetter) {
        if (motSecret.contains(guessedLetter)) {
            lettresDevinees += guessedLetter;
        }

        StringBuilder displayText = new StringBuilder();

        for (int i = 0; i < motSecret.length(); i++) {
            char letter = motSecret.charAt(i);
            if (lettresDevinees.indexOf(letter) != -1) {
                displayText.append(letter).append(" ");
            } else {
                displayText.append("_ ").append(" ");
            }
        }

        displayLabel.setText(displayText.toString().trim());
    }

    public void reset() {
        this.lettresDevinees = "";
        this.displayLabel.setText("");
        choisirMotSecret();  // Rechoisir un mot aléatoire
    }
}