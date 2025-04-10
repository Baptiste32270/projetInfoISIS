//Ousman GUERA
package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Panel principal du jeu du pendu.
 * C’est lui qui regroupe tous les composants graphiques :
 * - Le dessin du pendu
 * - Le mot à deviner
 * - Le clavier de lettres
 * - Le bouton "Nouvelle Partie"
 */
public class PenduFinal extends JPanel {

    // Composants principaux du jeu
    private DessinPanel dessinPanel;
    private MotPanel motPanel;
    private LettrePanel lettrePanel;

    /**
     * Constructeur du panel principal.
     * Il prépare l’interface utilisateur complète.
     */
    public PenduFinal(JFrame frame) {
        setLayout(new BorderLayout()); // Organisation principale des éléments
        initComponents();              // Création des composants
        setupInterface();              // Disposition et interactions
    }

    /**
     * Crée et configure les composants graphiques du jeu :
     * le dessin, le mot, et le clavier.
     */
    private void initComponents() {
        // Panneau qui dessine le pendu
        dessinPanel = new DessinPanel();

        // Panneau qui affiche le mot et gère la logique du jeu
        motPanel = new MotPanel(new Font("Arial", Font.BOLD, 24), dessinPanel);

        // Panneau du clavier des lettres
        lettrePanel = new LettrePanel(motPanel);

        // On donne au motPanel une référence au clavier pour pouvoir le réinitialiser
        motPanel.setLettrePanel(lettrePanel);
    }

    /**
     * Organise les composants sur le panneau principal
     * et ajoute le bouton "Nouvelle Partie".
     */
    private void setupInterface() {
        // Création du bouton de réinitialisation
        JButton btnNouvellePartie = new JButton("Nouvelle Partie");

        // Ajout d'un écouteur d’événement : lance une nouvelle partie
        btnNouvellePartie.addActionListener(e -> motPanel.resetGame());

        // Panneau qui contient le bouton, aligné à droite
        JPanel panelBouton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBouton.add(btnNouvellePartie);

        // Ajout des composants à la bonne position dans le panneau principal
        add(dessinPanel, BorderLayout.CENTER);  // Centre : pendu
        add(motPanel, BorderLayout.NORTH);      // Haut : mot à deviner
        add(lettrePanel, BorderLayout.SOUTH);   // Bas : clavier
        add(panelBouton, BorderLayout.EAST);    // Droite : bouton "Nouvelle Partie"
    }
}
