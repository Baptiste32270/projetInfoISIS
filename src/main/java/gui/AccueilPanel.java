package gui;


import javax.swing.*;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccueilPanel extends JPanel {

    public AccueilPanel(JFrame frame) {
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 20);

        //Bouton pour l'Ardoise Magique
        JButton dessin = new JButton("Ardoise Magique");
        dessin.setBounds(607, 210, 300, 100);
        dessin.setFont(font);
        this.add(dessin);
        dessin.addActionListener(e -> {
            if (frame instanceof Frame) {
                ((Frame) frame).voirPanel("ARDOISE_FACILE");
            }
        });

        //Bouton pour le Pendu (Action à compléter)
        JButton pendu = new JButton("Pendu");
        pendu.setBounds(607, 330, 300, 100);
        pendu.setFont(font);
        pendu.addActionListener(e -> {
            if (frame instanceof Frame) {
                ((Frame) frame).voirPanel("PENDU");
            }
        });
        this.add(pendu);

        //Bouton pour le Calcul Mental
        JButton calcul = new JButton("Calcul Mental");
        calcul.setBounds(607, 450, 300, 100);
        calcul.setFont(font);
        calcul.addActionListener(e -> {
            if (frame instanceof Frame) {
                ((Frame) frame).voirPanel("CALCUL_FACILE");
            }
        });
        this.add(calcul);
    }
}

