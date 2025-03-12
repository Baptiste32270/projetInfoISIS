package gui;

/**
 * Les fonctionnalités minimales attendues d'un afficheur.
 * Principe d'inversion
 * de dépendance pour affaiblir la dépendance des DigitsPanel et OperationsPanel
 * à la classe DisplayPanel
 *
 * @author Herbert Caffarel
 */
public interface DisplayInterface {

    /**
     * Remet l'afficheur à 0.
     */
    void reset();

    /**
     * Retourne le contenu de l'afficheur.
     *
     * @return Le contenu de l'afficheur
     */
    String getText();

    /**
     * Force l'afficheur à la valeur fournie.
     * @param text Le texte à afficher
     */
    void setText(String text);

    /**
     * Ajoute du contenu à l'afficheur. Si le contenu à afficher est un "."
     * vérifie s'il n'y en a pas déjà un.
     *
     * @param text
     */
    void append(String text);
}
