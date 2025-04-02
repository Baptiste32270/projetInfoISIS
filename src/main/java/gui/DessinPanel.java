package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau qui dessine progressivement le pendu selon le nombre d'erreurs
 */
public class DessinPanel extends JPanel {
    private int attemptsLeft;
    private int partiesGagnees = 0;
    private int partiesPerdues = 0;

    /**
     * Constructeur initialisant le nombre de tentatives
     */
    public DessinPanel() {
        this.attemptsLeft = 6;
        setPreferredSize(new Dimension(300, 400));
    }

    /**
     * Décrémente le nombre de tentatives restantes
     */
    public void decrementerTentatives() {
        attemptsLeft--;
        repaint();
    }

    /**
     * Réinitialise le dessin pour une nouvelle partie
     */
    public void reset() {
        attemptsLeft = 6;
        repaint();
    }

    /**
     * @return Le nombre de tentatives restantes
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Incrémente le compteur de parties gagnées
     */
    public void incrementerVictoires() {
        partiesGagnees++;
    }

    /**
     * Incrémente le compteur de parties perdues
     */
    public void incrementerDefaites() {
        partiesPerdues++;
    }

    /**
     * @return Le nombre de parties gagnées
     */
    public int getPartiesGagnees() {
        return partiesGagnees;
    }

    /**
     * @return Le nombre de parties perdues
     */
    public int getPartiesPerdues() {
        return partiesPerdues;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerPendu(g);
        dessinerScores(g);
    }

    /**
     * Dessine le pendu selon le nombre d'erreurs
     */
    private void dessinerPendu(Graphics g) {
        g.setColor(Color.BLACK);
        // Poteau
        g.fillRect(50, 50, 10, 300);
        // Traverse
        g.fillRect(50, 50, 150, 10);
        // Cordes
        g.fillRect(190, 50, 5, 30);

        if (attemptsLeft < 6) g.drawOval(175, 80, 40, 40);        // Tête
        if (attemptsLeft < 5) g.drawLine(195, 120, 195, 220);     // Corps
        if (attemptsLeft < 4) g.drawLine(195, 140, 150, 170);     // Bras gauche
        if (attemptsLeft < 3) g.drawLine(195, 140, 240, 170);     // Bras droit
        if (attemptsLeft < 2) g.drawLine(195, 220, 150, 270);     // Jambe gauche
        if (attemptsLeft < 1) g.drawLine(195, 220, 240, 270);     // Jambe droite
    }

    /**
     * Affiche les scores en bas du pendu
     */
    private void dessinerScores(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Victoires: " + partiesGagnees, 50, 380);
        g.drawString("Défaites: " + partiesPerdues, 50, 400);
    }
}