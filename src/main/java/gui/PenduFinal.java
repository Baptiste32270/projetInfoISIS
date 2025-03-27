package gui;

import javax.swing.*;
import java.awt.*;

public class PenduFinal extends JFrame {

    public PenduFinal() {
        this("Pendu");
    }

    public PenduFinal(String title) {
        super(title);
        initGui();
    }  

    private void initGui() {
        JPanel root = new JPanel();
        BorderLayout bl = new BorderLayout(5, 5);
        root.setLayout(bl);
        
        // Création des panneaux
        PenduPanel dessin = new PenduPanel();
        LettrePanel lettre = new LettrePanel();
        MotPanel mot = new MotPanel();
        
        // Ajout des panneaux
        root.add(dessin, BorderLayout.WEST);
        root.add(lettre, BorderLayout.SOUTH);
        root.add(mot, BorderLayout.EAST);
        
        // Configuration de la fenêtre
        this.add(root);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }
}