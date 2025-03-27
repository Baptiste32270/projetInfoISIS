/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author bapti
 */
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccueilPanel extends JPanel {
	
	public AccueilPanel(JFrame frame) {
		this.setLayout(null);
		Font font = new Font("Arial", Font.BOLD, 20);
		JButton dessin = new JButton("Ardoise Magique");
		dessin.setBounds(607,210,300,100);
		dessin.setFont(font);
		this.add(dessin);
		JButton pendu = new JButton("Pendu");
		pendu.setBounds(607,330,300,100);
		pendu.setFont(font);
		this.add(pendu);
		JButton calcul = new JButton("Calcul Mental");
		calcul.setBounds(607,450,300,100);
		calcul.setFont(font);
		this.add(calcul);
	}
}
