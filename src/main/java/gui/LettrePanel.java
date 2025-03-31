package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Panneau contenant le clavier de lettres
 */
public class LettrePanel extends JPanel {
    private final MotPanel motPanel;
    private final LettresButton[] boutons;
    
    public LettrePanel(MotPanel motPanel) {
        this.motPanel = motPanel;
        this.boutons = new LettresButton[26];
        initClavier();
    }
    
    private void initClavier() {
        setLayout(new GridLayout(2, 13, 3, 3));
        String[] lettres = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");
        
        for (int i = 0; i < lettres.length; i++) {
            LettresButton bouton = new LettresButton(lettres[i]);
            bouton.addActionListener(this::gererClicLettre);
            boutons[i] = bouton;
            add(bouton);
        }
    }
    
    private void gererClicLettre(ActionEvent e) {
        LettresButton bouton = (LettresButton) e.getSource();
        String lettre = bouton.getText();
        motPanel.devinerLettre(lettre, bouton);
    }
    
    public void resetBoutons() {
        for (LettresButton bouton : boutons) {
            bouton.reset();
        }
    }
}