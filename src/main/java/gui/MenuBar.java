/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author bapti
 */

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;


public class MenuBar extends JMenuBar {
	
	public MenuBar() {
		JMenu activite = new JMenu("Activités");
		JMenuItem dessin = new JMenuItem("Ardoise Magique");
		JMenuItem calcul = new JMenuItem("Calcul Mental");
		JMenuItem pendu = new JMenuItem("Pendu");
		
		JMenu difficulte = new JMenu("Difficulté");
		JMenuItem facile = new JMenuItem("Facile");
		JMenuItem difficile = new JMenuItem("Difficile");
		
		difficulte.add(facile);
		difficulte.add(new JSeparator());
		difficulte.add(difficile);
		
		activite.add(dessin);
		activite.add(new JSeparator());
		activite.add(calcul);
		activite.add(new JSeparator());
		activite.add(pendu);
		
		this.add(activite);
		this.add(difficulte);
                
                
                
	}

}
