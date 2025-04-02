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
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AdminPanel extends JPanel {
    private static final String HASHED_PASSWORD = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd819ecfb2f5b1a1ff"; // "password" en SHA-256
    private static final String DICTIONARY_FILE = "mots.txt";

    private JTextField wordField;
    private JTextArea wordList;
    
    public AdminPanel(Frame frame) {
        setLayout(new BorderLayout());
        showLoginScreen(frame);
    }

    /**
     * Affiche l'écran de connexion
     */
    private void showLoginScreen(Frame frame) {
        JPanel loginPanel = new JPanel(new GridLayout(3, 1));
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Connexion");

        loginButton.addActionListener(e -> {
            String enteredPassword = new String(passwordField.getPassword());
            if (checkPassword(enteredPassword)) {
                removeAll();
                showAdminScreen(frame);
                revalidate();
                repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginPanel.add(new JLabel("Entrez le mot de passe :"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel, BorderLayout.CENTER);
    }

    /**
     * Affiche l'interface d'administration pour gérer les mots du dictionnaire
     */
    private void showAdminScreen(Frame frame) {
        setLayout(new BorderLayout());

        // Liste des mots
        wordList = new JTextArea(10, 30);
        wordList.setEditable(false);
        updateWordList();
        
        // Champ de saisie
        wordField = new JTextField(20);
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Supprimer");
        JButton backButton = new JButton("Retour");

        addButton.addActionListener(e -> addWord());
        removeButton.addActionListener(e -> removeWord());
        backButton.addActionListener(e -> frame.showCard("ACCUEIL"));

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Mot :"));
        inputPanel.add(wordField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        add(new JScrollPane(wordList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(backButton, BorderLayout.NORTH);
    }

    /**
     * Vérifie si le mot de passe est correct (hash SHA-256)
     */
    private boolean checkPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString().equals(HASHED_PASSWORD);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Met à jour la liste des mots affichés
     */
    private void updateWordList() {
        try {
            List<String> words = Files.readAllLines(Paths.get(DICTIONARY_FILE));
            wordList.setText(String.join("\n", words));
        } catch (Exception e) {
            wordList.setText("Erreur : Impossible de charger le dictionnaire.");
        }
    }

    /**
     * Ajoute un mot au fichier
     */
    private void addWord() {
        String word = wordField.getText().trim().toLowerCase();
        if (!word.isEmpty()) {
            try {
                Files.write(Paths.get(DICTIONARY_FILE), (word + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                updateWordList();
                wordField.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout du mot", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Supprime un mot du fichier
     */
    private void removeWord() {
        String wordToRemove = wordField.getText().trim().toLowerCase();
        if (!wordToRemove.isEmpty()) {
            try {
                List<String> words = Files.readAllLines(Paths.get(DICTIONARY_FILE));
                words.removeIf(word -> word.equalsIgnoreCase(wordToRemove));
                Files.write(Paths.get(DICTIONARY_FILE), words, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
                updateWordList();
                wordField.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la suppression", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
