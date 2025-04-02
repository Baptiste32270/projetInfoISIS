/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author bapti
 */
import javax.swing.*;

public class MenuBar extends JMenuBar {
    private Frame frame;

    public MenuBar(JFrame frame) {
        if (frame instanceof Frame) {
            this.frame = (Frame) frame;
        } else {
            throw new IllegalArgumentException("Erreur : la frame doit être une instance de Frame !");
        }

        // 🔹 Menu Activités
        JMenu activite = new JMenu("Activités");

        JMenuItem dessin = new JMenuItem("Ardoise Magique");
        dessin.addActionListener(e -> this.frame.showCard("ARDOISE_FACILE"));

        JMenuItem calcul = new JMenuItem("Calcul Mental");
        calcul.addActionListener(e -> this.frame.showCard("CALCUL_FACILE"));

        JMenuItem pendu = new JMenuItem("Pendu");
        // TODO : Ajouter l'action pour le Pendu si nécessaire

        activite.add(dessin);
        activite.add(new JSeparator());
        activite.add(calcul);
        activite.add(new JSeparator());
        activite.add(pendu);

        // 🔹 Menu Accueil
        JMenu retour = new JMenu("Accueil");
        JMenuItem accueil = new JMenuItem("Accueil");
        accueil.addActionListener(e -> this.frame.showCard("ACCUEIL"));
        retour.add(accueil);

        // 🔹 Menu Difficulté
        JMenu difficulte = new JMenu("Difficulté");

        JMenuItem facile = new JMenuItem("Facile");
        facile.addActionListener(e -> switchDifficulty(true)); // Facile → Difficile

        JMenuItem difficile = new JMenuItem("Difficile");
        difficile.addActionListener(e -> switchDifficulty(false)); // Difficile → Facile

        difficulte.add(facile);
        difficulte.add(new JSeparator());
        difficulte.add(difficile);

        // 🔹 Ajout des menus à la barre de menu
        this.add(retour);
        this.add(activite);
        this.add(difficulte);
    }

    /**
     * Change la difficulté en fonction du panneau actuellement affiché.
     * @param toDifficult true si on veut passer en mode difficile, false si on veut revenir en facile.
     */
    private void switchDifficulty(boolean toDifficult) {
        String currentPanel = frame.getCurrentCard();
        System.out.println("Panel actuel : " + currentPanel); // DEBUG

        switch (currentPanel) {
            case "ARDOISE_FACILE":
                frame.showCard("ARDOISE_DIFFICILE");
                break;
            case "ARDOISE_DIFFICILE":
                frame.showCard("ARDOISE_FACILE");
                break;
            case "CALCUL_FACILE":
                frame.showCard("CALCUL_DIFFICILE");
                break;
            case "CALCUL_DIFFICILE":
                frame.showCard("CALCUL_FACILE");
                break;
            default:
                System.out.println("Aucun changement de difficulté possible sur ce panneau.");
                break;
        }
    }
}
