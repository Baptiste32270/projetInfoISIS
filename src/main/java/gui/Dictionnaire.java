package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionnaire {
    private List<String> mots;

    public Dictionnaire() {
        mots = new ArrayList<>();
        // Ajout de quelques mots par défaut
        mots.add("PENDU");
        mots.add("JAVA");
        mots.add("PROGRAMMATION");
        mots.add("ORDINATEUR");
    }

    public String getMotAleatoire() {
        Random random = new Random();
        return mots.get(random.nextInt(mots.size()));
    }

    public void ajouterMot(String mot) {
        if (!mots.contains(mot)) {
            mots.add(mot);
        }
    }

    public void supprimerMot(String mot) {
        mots.remove(mot);
    }

    // ✅ Ajout de la méthode getMots() pour récupérer la liste des mots
    public List<String> getMots() {
        return new ArrayList<>(mots);  // Retourne une copie pour éviter les modifications directes
    }
}
