/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author bapti
 */
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	public Frame() throws HeadlessException {
        this("Jeux pour enfants");
    }

	public Frame(String title) throws HeadlessException {
        super(title);
        initGui();
    }
	
	private void initGui() {
		JPanel root = new JPanel();
            BorderLayout bl = new BorderLayout(5, 5);
            root.setLayout(bl);
        
            AccueilPanel accueil = new AccueilPanel(this); //Panel Accueil
            accueil.setLayout(null);
            accueil.setBounds(0,0,this.getWidth(), this.getHeight()); //Panel accueil à la taille de la fenetre
            ArdoiseFacile ardoisef = new ArdoiseFacile(this); //Panel ardoise facile
            ArdoiseDifficile ardoised = new ArdoiseDifficile(this); //Panel ardoise difficile
            root.add(accueil);
            MenuBar menu = new MenuBar(this);
            this.add(root);
            this.setJMenuBar(menu);
        
            this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Taille de la fenêtre au maximum
            this.setLocationRelativeTo(null); //Fenêtre centrée
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setVisible(true);
    }

    
        
}
