package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton personnalisé pour les lettres du clavier
 */
public class LettresButton extends JButton {
    private boolean dejaClique = false;

    /**
     * Constructeur du bouton de lettre
     * @param text La lettre à afficher sur le bouton
     */
    public LettresButton(String text) {
        super(text);
        setProperties();
    }

    /**
     * Configure les propriétés visuelles du bouton
     */
    private void setProperties() {
        setFont(new Font("Arial", Font.BOLD, 20));
        setBorderPainted(true);
        setFocusPainted(false);
    }

    /**
     * Marque le bouton comme déjà cliqué (change la couleur)
     * @param estCorrect true si la lettre était dans le mot
     */
    public void setClique(boolean estCorrect) {
        dejaClique = true;
        if (estCorrect) {
            setBackground(Color.GREEN);
        } else {
            setBackground(Color.WHITE);
        }
        setOpaque(true);
        setEnabled(false);
    }

    /**
     * Réinitialise l'état du bouton
     */
    public void reset() {
        dejaClique = false;
        setBackground(null);
        setOpaque(false);
        setEnabled(true);
    }
}