/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author oguera
 */
public class PenduFinal extends JFrame{
    public PenduFinal() throws HeadlessException {
        this("Pendu");
    }
    public PenduFinal(String title) throws HeadlessException {
        super(title);
        initGui();
    
   
    }  

    private void initGui() {
        JPanel root = new JPanel();
        BorderLayout bl = new BorderLayout(5, 5);
        root.setLayout(bl);
        // Créer 3 conteneurs pour mes 3 espaces
        PenduPanel dessin = new PenduPanel();
        LettrePanel lettre = new LettrePanel();
        // Les ajouter à mon conteneur de base
        root.add(dessin, BorderLayout.NORTH);
        root.add(lettre, BorderLayout.WEST);
        this.add(root);
        
        // Configurer le comportement de la fenêtre
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }
}
    
        
