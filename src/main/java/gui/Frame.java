/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author bapti
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    private CardLayout cardLayout;
    private JPanel root;
    private String currentCard = "ACCUEIL"; // Variable pour stocker le panneau actuel

    public Frame() {
        this("Jeux pour enfants");
    }

    public Frame(String titre) {
        super(titre);
        initGui();
    }

    private void initGui() {
        //Création du CardLayout et du panel root
        cardLayout = new CardLayout();
        root = new JPanel(cardLayout);

        //Création et ajout des panneaux
        AccueilPanel accueil = new AccueilPanel(this);
        ArdoiseFacile ardoisef = new ArdoiseFacile(this);
        CalculMentalFacile calculf = new CalculMentalFacile(18, this);
        ArdoiseDifficile ardoised = new ArdoiseDifficile(this);
        CalculMentalDifficile calculd = new CalculMentalDifficile(18, this);
        PenduFinal pendu = new PenduFinal(this);
        AdminPanel admin = new AdminPanel();

        root.add(accueil, "ACCUEIL");
        root.add(ardoisef, "ARDOISE_FACILE");
        root.add(calculf, "CALCUL_FACILE");
        root.add(ardoised, "ARDOISE_DIFFICILE");
        root.add(calculd, "CALCUL_DIFFICILE");
        root.add(pendu, "PENDU");
        root.add(admin, "ADMINISTRATION");

        //Ajout du panel root à la fenêtre
        this.setLayout(new BorderLayout());
        this.add(root, BorderLayout.CENTER);

        //Ajout de la barre de menu
        MenuBar menu = new MenuBar(this);
        this.setJMenuBar(menu);

        //Paramètres de la fenêtre
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    //Méthode pour changer de panneau
    public void showCard(String name) {
        cardLayout.show(root, name);
        currentCard = name; // Mise à jour du panneau actuel
    }

    //Méthode pour récupérer le panneau actuellement affiché
    public String getCurrentCard() {
        return currentCard;
    }
}

