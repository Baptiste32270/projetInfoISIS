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

/**
 * Panneau pour dessiner le pendu en noir.
 */
@SuppressWarnings("serial")
public class PenduPanel extends JPanel {

    private int attemptsLeft;

    public PenduPanel() {
        this.attemptsLeft = 6; // Nombre maximal de tentatives
    }

    public void setAttemptsLeft(int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
        repaint(); // Redessiner après la mise à jour des tentatives
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner le poteau du pendu
        g.setColor(Color.BLACK);
        g.fillRect(50, 150, 10, 200);  // Poteau
        g.fillRect(50, 150, 100, 10);  // Barre horizontale

        // Dessiner le pendu en fonction du nombre de tentatives
        switch (attemptsLeft) {
            case 5: // Tête
                g.setColor(Color.BLACK);  // Dessiner la tête en noir
                g.fillOval(120, 170, 30, 30);  // Tête (cercle)
                break;
            case 4: // Torse
                g.setColor(Color.BLACK);  // Dessiner le torse en noir
                g.drawLine(135, 200, 135, 250);  // Torse (ligne verticale)
                break;
            case 3: // Bras gauche
                g.setColor(Color.BLACK);  // Dessiner le bras gauche en noir
                g.drawLine(135, 210, 100, 230);  // Bras gauche (ligne diagonale)
                break;
            case 2: // Bras droit
                g.setColor(Color.BLACK);  // Dessiner le bras droit en noir
                g.drawLine(135, 210, 170, 230);  // Bras droit (ligne diagonale)
                break;
            case 1: // Jambes gauche
                g.setColor(Color.BLACK);  // Dessiner la jambe gauche en noir
                g.drawLine(135, 250, 100, 290);  // Jambe gauche (ligne diagonale)
                break;
            case 0: // Jambes droite
                g.setColor(Color.BLACK);  // Dessiner la jambe droite en noir
                g.drawLine(135, 250, 170, 290);  // Jambe droite (ligne diagonale)
                break;
        }
    }
}