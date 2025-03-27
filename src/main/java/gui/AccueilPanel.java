package gui;

import javax.swing.*;
import java.awt.Font;

public class AccueilPanel extends JPanel {
    
    public AccueilPanel() {
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 20);
        
        // Création des boutons
        JButton dessin = new JButton("Ardoise Magique");
        dessin.setBounds(607, 210, 300, 100);
        dessin.setFont(font);
        this.add(dessin);

        JButton pendu = new JButton("Pendu");
        pendu.setBounds(607, 330, 300, 100);
        pendu.setFont(font);
        this.add(pendu);

        JButton calcul = new JButton("Calcul Mental");
        calcul.setBounds(607, 450, 300, 100);
        calcul.setFont(font);
        this.add(calcul);
    }
}