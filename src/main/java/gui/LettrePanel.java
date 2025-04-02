package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau contenant le clavier de lettres
 */
public class LettrePanel extends JPanel {
    private final MotPanel motPanel;
    
    public LettrePanel(MotPanel motPanel) {
        this.motPanel = motPanel;
        initClavier();
    }
    
    private void initClavier() {
        setLayout(new GridLayout(2, 13, 3, 3));
        
        String[] lettres = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };

        // Création des boutons avec la nouvelle méthode de gestion des événements
        for (String lettre : lettres) {
            LettresButton bouton = new LettresButton(lettre);
            bouton.setFont(new Font("Arial", Font.BOLD, 20));
            
            // Gestion de l'événement avec la syntaxe demandée
            bouton.addActionListener((e) -> {
                motPanel.devinerLettre(lettre, bouton);
            });
            
            this.add(bouton);
        }
    }
    
    public void resetBoutons() {
        Component[] components = this.getComponents();
        for (Component component : components) {
                ((LettresButton) component).reset();
            }
        }
    }
