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
    private boolean isDifficult;

    public MenuBar(JFrame frame) {
        if (frame instanceof Frame) {
            this.frame = (Frame) frame;
        } else {
            throw new IllegalArgumentException("Erreur : la frame doit être une instance de Frame !");
        }

        // 🔹 Menu Activités
        JMenu activite = new JMenu("Activités");

        JMenuItem dessin = new JMenuItem("Ardoise Magique");
        dessin.addActionListener(e -> this.frame.voirPanel("ARDOISE_FACILE"));

        JMenuItem calcul = new JMenuItem("Calcul Mental");
        calcul.addActionListener(e -> this.frame.voirPanel("CALCUL_FACILE"));

        JMenuItem pendu = new JMenuItem("Pendu");
        pendu.addActionListener(e -> this.frame.voirPanel("PENDU"));

        activite.add(dessin);
        activite.add(new JSeparator());
        activite.add(calcul);
        activite.add(new JSeparator());
        activite.add(pendu);

        //Menu Accueil
        JMenu retour = new JMenu("Accueil");
        JMenuItem accueil = new JMenuItem("Accueil");
        accueil.addActionListener(e -> this.frame.voirPanel("ACCUEIL"));
        retour.add(accueil);

        //Menu Difficulté
        JMenu difficulte = new JMenu("Difficulté");

        JMenuItem facile = new JMenuItem("Facile");
        facile.addActionListener(e -> switchDifficulty(false)); // Facile → Difficile

        JMenuItem difficile = new JMenuItem("Difficile");
        difficile.addActionListener(e -> switchDifficulty(true)); // Difficile → Facile

        difficulte.add(facile);
        difficulte.add(new JSeparator());
        difficulte.add(difficile);
        
        //Menu Administration
        JMenu admin = new JMenu("Administration");
        
        JMenuItem connexion = new JMenuItem("Connexion");
        connexion.addActionListener(e -> {
            // On demande le mot de passe à chaque fois qu'on accède à la page Admin
            if (new AdminPanel() != null) {
                this.frame.voirPanel("ADMINISTRATION");
            } else {
                JOptionPane.showMessageDialog(frame, "Mot de passe incorrect.");
            }
        });
        
        admin.add(connexion);

        //Ajout des menus à la barre de menu
        this.add(retour);
        this.add(activite);
        this.add(difficulte);
        this.add(admin);
    }

    private void switchDifficulty(boolean toDifficult) {
        if (isDifficult == toDifficult) {
            return;
        }

        String currentPanel = frame.panelActuel();

        switch (currentPanel) {
            case "ARDOISE_FACILE":
                frame.voirPanel("ARDOISE_DIFFICILE");
                break;
            case "ARDOISE_DIFFICILE":
                frame.voirPanel("ARDOISE_FACILE");
                break;
            case "CALCUL_FACILE":
                frame.voirPanel("CALCUL_DIFFICILE");
                break;
            case "CALCUL_DIFFICILE":
                frame.voirPanel("CALCUL_FACILE");
                break;
            default:
                System.out.println("Aucun changement de difficulté possible sur ce panneau.");
                break;
        }

        isDifficult = toDifficult;
    }
}
