package gui;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Dictionnaire {

    private static final String DICTIONARY_FILE = "words.txt"; // Fichier qui stocke les mots

    // Liste des mots
    private static List<String> mots;

    static {
        mots = new ArrayList<>();
        loadMots();  // Charge les mots depuis le fichier lors de l'initialisation de la classe
    }

    // Charger les mots depuis le fichier
    private static void loadMots() {
        try {
            if (Files.exists(Paths.get(DICTIONARY_FILE))) {
                mots = Files.readAllLines(Paths.get(DICTIONARY_FILE), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Sauvegarder les mots dans le fichier
    private static void saveMots() {
        try {
            Files.write(Paths.get(DICTIONARY_FILE), mots, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ajouter un mot au dictionnaire
    public static void addMot(String mot) {
        if (!mots.contains(mot.toUpperCase())) {  // Eviter les doublons
            mots.add(mot.toUpperCase());
            saveMots();
        }
    }

    // Supprimer un mot du dictionnaire
    public static void removeMot(String mot) {
        mots.remove(mot.toUpperCase());
        saveMots();
    }

    // Retourner un mot aléatoire du dictionnaire
    public static String getMotAleatoire() {
        if (mots.isEmpty()) {
            return null;  // Si le dictionnaire est vide
        }
        int index = (int) (Math.random() * mots.size());
        return mots.get(index);  // Retourner le mot sous forme de chaîne
    }

    // Retourner tous les mots sous forme de liste
    public static List<String> getAllMots() {
        return mots;
    }
}
