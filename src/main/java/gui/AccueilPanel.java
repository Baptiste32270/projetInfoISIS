package gui;

import javax.swing.*;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccueilPanel extends JPanel {
	
	public AccueilPanel(JFrame frame) {
		this.setLayout(null);
		Font font = new Font("Arial", Font.BOLD, 20); //On définit le style des caractère et leurs tailles
                
            JButton dessin = new JButton("Ardoise Magique");
            dessin.setBounds(607,210,300,100); //taille et placement du bouton Ardoise Magique
            dessin.setFont(font);
            this.add(dessin);
            dessin.addActionListener(e -> {
                frame.setContentPane(new ArdoiseFacile(frame)); //Le panel dans notre frame devient le Panel ArdoiseFacile
                frame.revalidate();
                frame.repaint();
            });
                
            JButton pendu = new JButton("Pendu");
            pendu.setBounds(607,330,300,100);
            pendu.setFont(font);
            this.add(pendu);
                
            JButton calcul = new JButton("Calcul Mental");
            calcul.setBounds(607,450,300,100);
            calcul.setFont(font);
            calcul.addActionListener(e -> {
                frame.setContentPane(new CalculMentalFacile(18, frame));
                frame.revalidate();
                frame.repaint();
            });
            this.add(calcul);
    }
}
