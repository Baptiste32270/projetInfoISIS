/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author oguera
 */
public enum Dictionnaire{
        INGENIEUR,
        ECOLE,
        PROFFESSEUR,
        ENSEIGNEMENT,
        INFORMATIQUE,
        EVOLUER,
        CLASSE;
    
public static String getMotAleatoire() {
        Dictionnaire[] mots = Dictionnaire.values();
        int index = (int) (Math.random() * mots.length);  // Choisir un mot aléatoire
        return mots[index].name();  // Retourner le mot sous forme de chaîne
    }
}

