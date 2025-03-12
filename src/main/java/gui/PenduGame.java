package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PenduGame extends JFrame {

    private final String[] dictionary = {
            "JAVA", "PYTHON", "SWING", "COMPUTER", "PROGRAMMING", "DEVELOPER", "ALGORITHM"
    };
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int wrongGuesses;
    private final JLabel wordLabel;
    private final JLabel hangmanLabel;
    private final JButton[] letterButtons = new JButton[26];

    public PenduGame() {
        setTitle("Jeu du Pendu");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Choisir un mot aléatoire du dictionnaire
        Random random = new Random();
        wordToGuess = dictionary[random.nextInt(dictionary.length)];
        currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        wrongGuesses = 0;

        // Création de l'affichage du mot à deviner
        wordLabel = new JLabel(currentGuess.toString(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(wordLabel, BorderLayout.NORTH);

        // Création du dessin du pendu
        hangmanLabel = new JLabel(getHangmanDrawing(), SwingConstants.CENTER);
        hangmanLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        add(hangmanLabel, BorderLayout.CENTER);

        // Création du clavier virtuel (pavé numérique)
        JPanel keyboardPanel = new JPanel(new GridLayout(3, 9, 5, 5));
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            int index = letter - 'A';
            letterButtons[index] = new JButton(String.valueOf(letter));
            letterButtons[index].addActionListener(new LetterButtonListener(letter));
            keyboardPanel.add(letterButtons[index]);
        }
        add(keyboardPanel, BorderLayout.SOUTH);
    }

    // Gestion des clics sur les boutons des lettres
    private class LetterButtonListener implements ActionListener {
        private final char letter;

        public LetterButtonListener(char letter) {
            this.letter = letter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Désactiver le bouton après clic
            JButton source = (JButton) e.getSource();
            source.setEnabled(false);

            // Vérifier si la lettre est dans le mot à deviner
            boolean letterFound = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    currentGuess.setCharAt(i, letter);
                    letterFound = true;
                }
            }

            // Si la lettre n'est pas dans le mot, augmenter le nombre d'erreurs
            if (!letterFound) {
                wrongGuesses++;
                hangmanLabel.setText(getHangmanDrawing());  // Actualiser l'affichage du pendu
            }

            // Mettre à jour l'affichage du mot
            wordLabel.setText(currentGuess.toString());

            // Vérifier si le jeu est terminé
            if (currentGuess.toString().equals(wordToGuess)) {
                JOptionPane.showMessageDialog(PenduGame.this, "Vous avez gagné ! Le mot était : " + wordToGuess);
                resetGame();
            } else if (wrongGuesses >= 6) {
                JOptionPane.showMessageDialog(PenduGame.this, "Vous avez perdu ! Le mot était : " + wordToGuess);
                resetGame();
            }
        }
    }

    // Retourner le dessin du pendu selon le nombre d'erreurs
    private String getHangmanDrawing() {
        switch (wrongGuesses) {
            case 0: return "______\n|    |\n|\n|\n|\n|";
            case 1: return "______\n|    |\n|    O\n|\n|\n|";
            case 2: return "______\n|    |\n|    O\n|    |\n|\n|";
            case 3: return "______\n|    |\n|    O\n|   /|\n|\n|";
            case 4: return "______\n|    |\n|    O\n|   /|\\\n|\n|";
            case 5: return "______\n|    |\n|    O\n|   /|\\\n|   /\n|";
            case 6: return "______\n|    |\n|    O\n|   /|\\\n|   / \\\n|";
            default: return "";
        }
    }

    // Réinitialiser le jeu
    private void resetGame() {
        Random random = new Random();
        wordToGuess = dictionary[random.nextInt(dictionary.length)];
        currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        wrongGuesses = 0;
        wordLabel.setText(currentGuess.toString());
        hangmanLabel.setText(getHangmanDrawing());
        for (JButton button : letterButtons) {
            button.setEnabled(true);  // Réactiver tous les boutons
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PenduGame game = new PenduGame();
            game.setVisible(true);
        });
    }
}
