/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bapti
 */
public class ArdoiseFacile extends JPanel {
    
    public ArdoiseFacile() {
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 10);
        
        JButton effacer = new JButton("Effacer");
        effacer.setFont(font);
        effacer.addActionListener(e -> effacer.clear());
        this.add(effacer);
        effacer.setBounds(500,700,100,50);
        
        JButton gomme = new JButton("Gomme");
        gomme.setFont(font);
        this.add(gomme);
        gomme.setBounds(610,700,100,50);
        
        JButton rouge = new JButton("Rouge");
        rouge.setForeground(Color.RED);
        rouge.setFont(font);
        this.add(rouge);
        rouge.setBounds(720,700,100,50);
        
        JButton vert = new JButton("Vert");
        vert.setFont(font);
        vert.setForeground(Color.GREEN);
        this.add(vert);
        vert.setBounds(830,700,100,50);
        
        JButton bleu = new JButton("Bleu");
        bleu.setFont(font);
        bleu.setForeground(Color.BLUE);
        this.add(bleu);
        bleu.setBounds(940,700,100,50);
        
        
    }
}
