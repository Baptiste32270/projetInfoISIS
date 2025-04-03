package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Dictionnaire {
    private static List<String> mots = Collections.emptyList();

    static {
        try {
            // Lit le fichier ligne par ligne (1 mot par ligne, déjà en majuscules)
            mots = Files.readAllLines(Paths.get("mots.txt"));
            // Supprime uniquement les lignes totalement vides
            mots.removeIf(String::isEmpty);
        } catch (IOException e) {
            System.err.println("Fichier 'mots.txt' introuvable");
            System.err.println(e.getMessage());
            System.exit(1); // Arrêt immédiat si le fichier est manquant
        }
    }

    public static String getMotAleatoire() {
        return mots.get(new Random().nextInt(mots.size()));
    }
}