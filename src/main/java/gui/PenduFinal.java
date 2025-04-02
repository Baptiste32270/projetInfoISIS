package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Panel principal du jeu du pendu qui remplace la JFrame
 */
public class PenduFinal extends JPanel {
    
    private DessinPanel dessinPanel;
    private MotPanel motPanel;
    private LettrePanel lettrePanel;
    
    /**
     * Constructeur du panel principal
     * @param frame
     */
    public PenduFinal(JFrame frame) {
        setLayout(new BorderLayout());
        initComponents();
        setupInterface();
    }
    
    /**
     * Initialise les composants du jeu
     */
    private void initComponents() {
        // Création des panels spécialisés
        dessinPanel = new DessinPanel();
        motPanel = new MotPanel(new Font("Arial", Font.BOLD, 24), dessinPanel);
        lettrePanel = new LettrePanel(motPanel);
        
        // Liaison entre les composants
        motPanel.setLettrePanel(lettrePanel);
    }
    
    /**
     * Configure l'interface et les interactions
     */
    private void setupInterface() {
        // Bouton Nouvelle Partie
        JButton btnNouvellePartie = new JButton("Nouvelle Partie");
        btnNouvellePartie.addActionListener(e -> motPanel.resetGame());
        
        // Panel pour le bouton (aligné à droite)
        JPanel panelBouton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBouton.add(btnNouvellePartie);
        
        // Organisation des composants principaux
        add(dessinPanel, BorderLayout.CENTER);
        add(motPanel, BorderLayout.NORTH);
        add(lettrePanel, BorderLayout.SOUTH);
        add(panelBouton, BorderLayout.EAST);   
    }
}