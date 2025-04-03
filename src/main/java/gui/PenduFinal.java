package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Panel principal du jeu du pendu qui remplace la JFrame.
 */
public class PenduFinal extends JPanel {

    private DessinPanel dessinPanel;
    private MotPanel motPanel;
    private LettrePanel lettrePanel;
    private Dictionnaire dictionnaire;  // Gestionnaire de mots

    /**
     * Constructeur du panel principal.
     * @param frame Référence à la JFrame principale.
     */
    public PenduFinal(JFrame frame) {
        setLayout(new BorderLayout());
        dictionnaire = new Dictionnaire();  // Initialisation du dictionnaire
        initComponents();
        setupInterface();
    }

    /**
     * Initialise les composants du jeu.
     */
    private void initComponents() {
        // Création des panels spécialisés
        dessinPanel = new DessinPanel();
        motPanel = new MotPanel(new Font("Arial", Font.BOLD, 24), dessinPanel, dictionnaire); // Passage du dictionnaire
        lettrePanel = new LettrePanel(motPanel);

        // Liaison entre les composants
        motPanel.setLettrePanel(lettrePanel);
    }

    /**
     * Configure l'interface et les interactions.
     */
    private void setupInterface() {
        // Bouton Nouvelle Partie
        JButton btnNouvellePartie = new JButton("Nouvelle Partie");
        btnNouvellePartie.addActionListener(e -> motPanel.resetGame());

        // Bouton pour ouvrir l'interface admin
        JButton btnAdmin = new JButton("Admin");
        btnAdmin.addActionListener(e -> ouvrirInterfaceAdmin());

        // Panel pour les boutons (alignés à droite)
        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoutons.add(btnNouvellePartie);
        panelBoutons.add(btnAdmin);  // Ajout du bouton Admin

        // Organisation des composants principaux
        add(dessinPanel, BorderLayout.CENTER);
        add(motPanel, BorderLayout.NORTH);
        add(lettrePanel, BorderLayout.SOUTH);
        add(panelBoutons, BorderLayout.EAST);
    }

    /**
     * Ouvre l'interface admin pour gérer les mots (dans une fenêtre pop-up).
     */
    private void ouvrirInterfaceAdmin() {
        if (AdminPanel.demanderConnexion(this)) { // Demande la connexion admin
            JDialog adminDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Panneau Admin", true);
            adminDialog.setSize(400, 300);
            adminDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            adminDialog.setLocationRelativeTo(this);

            AdminPanel adminPanel = new AdminPanel(dictionnaire);  // Passer le dictionnaire à l'admin
            adminDialog.add(adminPanel);

            adminDialog.setVisible(true); // Affiche la fenêtre admin
        } else {
            JOptionPane.showMessageDialog(this, "Identifiants incorrects !");
        }
    }
}
