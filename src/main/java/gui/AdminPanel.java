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

public class AdminPanel extends JPanel {

    private JTextField wordField;
    private JTextArea wordList;

    public AdminPanel(Frame frame) {
        setLayout(new BorderLayout());
        showLoginScreen(frame);  // L'écran de login de l'administrateur
    }

    private void showAdminScreen(Frame frame) {
        setLayout(new BorderLayout());

        // Liste des mots
        wordList = new JTextArea(10, 30);
        wordList.setEditable(false);
        updateWordList();  // Met à jour la liste des mots

        // Champ de saisie
        wordField = new JTextField(20);
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Supprimer");
        JButton backButton = new JButton("Retour");

        addButton.addActionListener(e -> addWord());
        removeButton.addActionListener(e -> removeWord());
        backButton.addActionListener(e -> frame.showCard("ACCUEIL")); // Retour au menu principal

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Mot :"));
        inputPanel.add(wordField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        add(new JScrollPane(wordList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(backButton, BorderLayout.NORTH);
    }

    // Afficher l'écran de login de l'administrateur
    private void showLoginScreen(Frame frame) {
        setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        JTextField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String password = passwordField.getText().trim();
            if (isValidPassword(password)) {
                showAdminScreen(frame);  // Passer à l'écran d'administration
            } else {
                JOptionPane.showMessageDialog(this, "Mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginPanel.add(new JLabel("Mot de passe :"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel, BorderLayout.CENTER);
    }

    // Vérifier le mot de passe
    private boolean isValidPassword(String password) {
        // Vérification simple avec un mot de passe prédéfini
        return "admin".equals(password);  // Changer ce mot de passe pour plus de sécurité
    }

    // Mettre à jour la liste des mots affichés
    private void updateWordList() {
        java.util.List<String> mots = Dictionnaire.getAllMots();
        wordList.setText(String.join("\n", mots));
    }

    // Ajouter un mot
    private void addWord() {
        String word = wordField.getText().trim().toUpperCase();
        if (!word.isEmpty()) {
            Dictionnaire.addMot(word);  // Ajouter le mot au dictionnaire
            updateWordList();  // Mettre à jour l'affichage
            wordField.setText("");  // Réinitialiser le champ de texte
        }
    }

    // Supprimer un mot
    private void removeWord() {
        String word = wordField.getText().trim().toUpperCase();
        if (!word.isEmpty()) {
            Dictionnaire.removeMot(word);  // Supprimer le mot du dictionnaire
            updateWordList();  // Mettre à jour l'affichage
            wordField.setText("");  // Réinitialiser le champ de texte
        }
    }
}
