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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel {
    private Dictionnaire dictionnaire;
    private JList<String> listeMots;
    private DefaultListModel<String> listModel;
    private JTextField champMot;
    private JButton btnFermer;

    public AdminPanel(Dictionnaire dictionnaire) {
        this.dictionnaire = dictionnaire;
        setLayout(new BorderLayout());
        initUI();
    }

    private void initUI() {
        // Liste des mots
        listModel = new DefaultListModel<>();
        mettreAJourListe();
        listeMots = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listeMots);

        // Champ pour ajouter un mot
        champMot = new JTextField(15);
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnSupprimer = new JButton("Supprimer");
        btnFermer = new JButton("Fermer");

        // Panel pour l'entrée utilisateur
        JPanel panelSaisie = new JPanel();
        panelSaisie.add(new JLabel("Mot: "));
        panelSaisie.add(champMot);
        panelSaisie.add(btnAjouter);
        panelSaisie.add(btnSupprimer);
        panelSaisie.add(btnFermer);

        // Actions des boutons
        btnAjouter.addActionListener(e -> ajouterMot());
        btnSupprimer.addActionListener(e -> supprimerMot());
        btnFermer.addActionListener(e -> fermerPanel());

        // Ajouter les composants au panel
        add(scrollPane, BorderLayout.CENTER);
        add(panelSaisie, BorderLayout.SOUTH);
    }

    private void mettreAJourListe() {
        listModel.clear();
        for (String mot : dictionnaire.getMots()) {
            listModel.addElement(mot);
        }
    }

    private void ajouterMot() {
        String mot = champMot.getText().trim().toUpperCase();
        if (!mot.isEmpty()) {
            dictionnaire.ajouterMot(mot);
            mettreAJourListe();
            champMot.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Entrez un mot valide !");
        }
    }

    private void supprimerMot() {
        String mot = listeMots.getSelectedValue();
        if (mot != null) {
            dictionnaire.supprimerMot(mot);
            mettreAJourListe();
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez un mot à supprimer !");
        }
    }

    private void fermerPanel() {
        this.setVisible(false); // Cache le panel sans le supprimer
    }

    public static boolean demanderConnexion(Component parent) {
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        Object[] message = {
            "Nom d'utilisateur:", usernameField,
            "Mot de passe:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(parent, message, "Connexion Admin", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            return "admin".equals(username) && "password".equals(password); // Vérification basique
        }
        return false;
    }
}
