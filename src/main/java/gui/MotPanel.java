package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

/**
 * Panneau qui gère le mot à deviner et la logique du jeu
 */
public class MotPanel extends JPanel {
    private String motSecret;
    private String lettresDevinees;
    private final JLabel displayLabel;
    private final DessinPanel dessinPanel;
    private LettrePanel lettrePanel;
    
    public MotPanel(Font font, DessinPanel dessinPanel) {
        this.dessinPanel = dessinPanel;
        this.displayLabel = new JLabel("", JLabel.CENTER);
        this.lettresDevinees = "";
        displayLabel.setFont(font);
        initAffichage();
        choisirMotSecret();
    }
    
    public void setLettrePanel(LettrePanel lettrePanel) {
        this.lettrePanel = lettrePanel;
    }
    
    private void initAffichage() {
        setLayout(new BorderLayout());
        displayLabel.setOpaque(true);
        displayLabel.setBackground(Color.LIGHT_GRAY);
        
        Border border = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );
        displayLabel.setBorder(border);
        add(displayLabel, BorderLayout.CENTER);
    }
    
    private void choisirMotSecret() {
        motSecret = Dictionnaire.getMotAleatoire();
        lettresDevinees = "";
        actualiserAffichage();
    }
    
    public void devinerLettre(String lettre, LettresButton bouton) {
        boolean estCorrect = motSecret.contains(lettre);
        bouton.setClique(estCorrect);
        
        if (estCorrect) {
            lettresDevinees += lettre;
        } else {
            dessinPanel.decrementerTentatives();
        }
        
        actualiserAffichage();
        verifierFinPartie();
    }
    
    private void actualiserAffichage() {
        StringBuilder sb = new StringBuilder();
        for (char c : motSecret.toCharArray()) {
            sb.append(lettresDevinees.contains(String.valueOf(c)) ? c + " " : "_ ");
        }
        displayLabel.setText(sb.toString().trim());
    }
    
    private void verifierFinPartie() {
        // Vérifier victoire
        if (motSecret.chars().allMatch(c -> lettresDevinees.contains(String.valueOf((char)c)))) {
            dessinPanel.incrementerVictoires();
            JOptionPane.showMessageDialog(this, "Gagné! Le mot était: " + motSecret);
            resetGame();
            return;
        }
        
        // Vérifier défaite
        if (dessinPanel.getAttemptsLeft() <= 0) {
            dessinPanel.incrementerDefaites();
            JOptionPane.showMessageDialog(this, "Perdu! Le mot était: " + motSecret);
            resetGame();
        }
    }
    
    public void resetGame() {
        choisirMotSecret();
        dessinPanel.reset();
        lettrePanel.resetBoutons();
    }
}