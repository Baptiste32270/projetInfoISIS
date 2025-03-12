package gui;

import javax.swing.JButton;
import java.awt.Font;

/**
 * Un bouton personnalisé pour afficher des lettres.
 */
public class LettresButton extends JButton {

    public LettresButton(String text) {
        super(text);  // Le texte du bouton
        setProperties();  // Personnalisation
    }

    // Personnalisation du bouton (sans couleurs)
    private void setProperties() {
        setFont(new Font("Arial", Font.BOLD, 20));  // Police
        setBorderPainted(true);  // Bordure visible;
    }
}