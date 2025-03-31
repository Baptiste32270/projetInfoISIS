package gui;

public enum Dictionnaire {
    INGENIEUR,
    ECOLE,
    PROFESSEUR,
    ENSEIGNEMENT,
    INFORMATIQUE,
    EVOLUER,
    CLASSE;
    
    public static String getMotAleatoire() {
        Dictionnaire[] mots = Dictionnaire.values();
        int index = (int) (Math.random() * mots.length);
        return mots[index].name();  // Retourner le mot sous forme de chaîne
    }
}