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
import java.awt.event.*;
import java.io.*;
import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class AdminPanel extends JPanel {
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> wordList = new JList<>(listModel);
    private JTextField wordField = new JTextField();
    private JButton addButton = new JButton("Ajouter");
    private JButton deleteButton = new JButton("Supprimer");

    private final String motsPath = "mots.txt";

    // ✅ Mot de passe haché "admin" pour test direct (remplacer par ton propre mot de passe haché)
    private final String storedHash = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918";  // Remplace avec ton propre hachage

    public AdminPanel() {
        setLayout(new BorderLayout());

        // Si l'utilisateur n'est pas autorisé, afficher "Accès refusé"
        if (!authorize()) {
            removeAll();
            add(new JLabel("Accès refusé", SwingConstants.CENTER), BorderLayout.CENTER);
            return;
        }

        loadWords();
        buildUI();
    }

    private boolean authorize() {
        // Demander le mot de passe avec un champ de texte sécurisé
        JPasswordField pwdField = new JPasswordField();
        int result = JOptionPane.showConfirmDialog(
                this,
                pwdField,
                "Mot de passe administrateur",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String inputPwd = new String(pwdField.getPassword()).trim();  // Nettoyer l'entrée de l'utilisateur (supprime les espaces)
            return checkPassword(inputPwd);
        }
        return false;
    }

    private boolean checkPassword(String inputPassword) {
        try {
            // Calculer le hash du mot de passe entré
            String inputHash = hashPassword(inputPassword);

            // ✅ DEBUG : Afficher les hachages pour vérifier
            System.out.println("Hash attendu    : " + storedHash);
            System.out.println("Hash utilisateur : " + inputHash);

            // Comparer les hachages
            if (!inputHash.equals(storedHash)) {
                System.out.println("❌ Mot de passe incorrect");
                return false;
            } else {
                System.out.println("✅ Mot de passe correct");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String hashPassword(String password) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedHash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    private void loadWords() {
        listModel.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(motsPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listModel.addElement(line.trim());
            }
        } catch (IOException e) {
            // fichier inexistant : on laisse vide
        }
    }

    private void saveWords() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(motsPath))) {
            for (int i = 0; i < listModel.size(); i++) {
                writer.write(listModel.getElementAt(i));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildUI() {
        wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(wordList);
        add(scrollPane, BorderLayout.CENTER);

        // Champ d'ajout + bouton
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(wordField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.NORTH);

        // Bouton suppression
        JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        deletePanel.add(deleteButton);
        add(deletePanel, BorderLayout.SOUTH);

        // Action pour ajouter un mot
        addButton.addActionListener(e -> {
            String word = wordField.getText().trim();  // Nettoyer les espaces autour du mot
            if (!word.isEmpty() && !listModel.contains(word)) {
                // Mettre le mot en majuscule et enlever les accents avant de l'ajouter
                word = normalizeWord(word);
                listModel.addElement(word);
                wordField.setText("");  // Réinitialiser le champ de texte
                saveWords();
            }
        });

        // Action pour supprimer un mot
        deleteButton.addActionListener(e -> {
            int selectedIndex = wordList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
                saveWords();
            }
        });
    }

    // Méthode pour transformer un mot en majuscule et sans accents
    private String normalizeWord(String word) {
        // Mettre le mot en majuscule
        word = word.toUpperCase();

        // Supprimer les accents
        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[^\\p{ASCII}]", "");  // Enlever les accents

        return word;
    }
}
