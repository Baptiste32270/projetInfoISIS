package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Fenêtre principale du jeu du pendu
 */
public class PenduFinal extends JFrame {
    
    public PenduFinal() {
        super("Jeu du Pendu");
        initInterface();
    }
    
    private void initInterface() {
        // Création des composants
        DessinPanel dessinPanel = new DessinPanel();
        MotPanel motPanel = new MotPanel(new Font("Arial", Font.BOLD, 24), dessinPanel);
        LettrePanel lettrePanel = new LettrePanel(motPanel);
        motPanel.setLettrePanel(lettrePanel);
        
        // Bouton Nouvelle Partie
        JButton btnNouvellePartie = new JButton("Nouvelle Partie");
        btnNouvellePartie.addActionListener(e -> motPanel.resetGame());
        
        // Organisation de l'interface
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(dessinPanel, BorderLayout.CENTER);
        mainPanel.add(motPanel, BorderLayout.NORTH);
        mainPanel.add(lettrePanel, BorderLayout.SOUTH);
        
        JPanel panelBouton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBouton.add(btnNouvellePartie);
        mainPanel.add(panelBouton, BorderLayout.EAST);
        
        // Configuration fenêtre
        setContentPane(mainPanel);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PenduFinal());
    }
}