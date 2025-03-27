package gui;

import javax.swing.*;
import java.awt.*;

public class PenduPanel extends JPanel {

    private int attemptsLeft;

    public PenduPanel() {
        this.attemptsLeft = 6;  // Nombre maximal de tentatives
        repaint();
    }

    public void setAttemptsLeft(int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
        repaint();  // Redessiner après la mise à jour des tentatives
    }

    private void drawPoteau(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(50, 150, 10, 200);  // Poteau
        g.fillRect(50, 150, 100, 10);  // Barre horizontale
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPoteau(g);

        switch (attemptsLeft) {
            case 5: // Tête
                g.setColor(Color.BLACK);
                g.fillOval(120, 170, 30, 30);  // Tête (cercle)
                break;
            case 4: // Torse
                g.setColor(Color.BLACK);
                g.drawLine(135, 200, 135, 250);  // Torse
                break;
            case 3: // Bras gauche
                g.setColor(Color.BLACK);
                g.drawLine(135, 210, 100, 230);  // Bras gauche
                break;
            case 2: // Bras droit
                g.setColor(Color.BLACK);
                g.drawLine(135, 210, 170, 230);  // Bras droit
                break;
            case 1: // Jambe gauche
                g.setColor(Color.BLACK);
                g.drawLine(135, 250, 100, 290);  // Jambe gauche
                break;
            case 0: // Jambe droite
                g.setColor(Color.BLACK);
                g.drawLine(135, 250, 170, 290);  // Jambe droite
                break;
        }
    }
}