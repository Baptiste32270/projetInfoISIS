/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author bapti
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class MenuBar extends JMenuBar {
	private JFrame frame;
	public MenuBar(JFrame frame) {
            ArdoiseFacile ardoiseFacile = new ArdoiseFacile(frame);
            ArdoiseDifficile ardoiseDifficile = new ArdoiseDifficile(frame);
            
            this.frame = frame;
            JMenu activite = new JMenu("Activités");
            JMenuItem dessin = new JMenuItem("Ardoise Magique");
            dessin.addActionListener(e -> {
                frame.setContentPane(new ArdoiseFacile(frame));
                frame.revalidate();
                frame.repaint();
            });
            JMenuItem calcul = new JMenuItem("Calcul Mental");
            calcul.addActionListener(e -> {
                frame.setContentPane(new CalculMentalFacile(18, frame));
                frame.revalidate();
                frame.repaint();
            });
            JMenuItem pendu = new JMenuItem("Pendu");
		
            JMenu retour = new JMenu("Accueil");
            JMenuItem accueil = new JMenuItem("Accueil");
            accueil.addActionListener(e -> {
                frame.setContentPane(new AccueilPanel(frame));
                frame.revalidate();
                frame.repaint();
            });
                
            JMenu difficulte = new JMenu("Difficulté");
            JMenuItem facile = new JMenuItem("Facile");
            JMenuItem difficile = new JMenuItem("Difficile");
            difficile.addActionListener(e -> {
                    //frame.setContentPane(new ArdoiseDifficile(frame));
                    frame.revalidate();
                    frame.repaint();});

            difficulte.add(facile);
            difficulte.add(new JSeparator());
            difficulte.add(difficile);
                
            retour.add(accueil);
		
            activite.add(dessin);
            activite.add(new JSeparator());
            activite.add(calcul);
            activite.add(new JSeparator());
            activite.add(pendu);
		
            this.add(retour);
            this.add(activite);
            this.add(difficulte);
	}
}
