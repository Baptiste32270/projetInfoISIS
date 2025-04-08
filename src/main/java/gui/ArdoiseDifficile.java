/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author bapti
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ArdoiseDifficile extends JPanel {
    private BufferedImage zondeDessin; // Zone de dessin
    private Graphics2D outil;       // Outil graphique pour dessiner
    private Color couleurPinceau = Color.RED; // Couleur actuelle (par défaut : rouge)
    private boolean efface = false;        // Mode gomme
    private int taillePinceau = 10;                // Taille du pinceau (10x10 pixels)
    private int tailleGomme = 30;               // Taille de la gomme (30x30 pixels)

    public ArdoiseDifficile(JFrame frame) {
        this.setLayout(null);

        // Dimensions de l'ardoise
        int canvasWidth = 1920;
        int canvasHeight = 680;

        // Créer la zone de dessin (BufferedImage)
        zondeDessin = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        outil = zondeDessin.createGraphics();
        outil.setColor(Color.WHITE); // Fond blanc
        outil.fillRect(0, 0, canvasWidth, canvasHeight);

        // Panel pour dessiner
        JPanel drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(zondeDessin, 0, 0, null); // Dessiner le contenu du canvas
            }
        };
        drawPanel.setBounds(0, 0, canvasWidth, canvasHeight);
        drawPanel.setBackground(Color.WHITE);
        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dessin(e.getX(), e.getY());
            }
        });
        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dessin(e.getX(), e.getY());
            }
        });
        this.add(drawPanel);

        // Barre d'outils (boutons)
        Font font = new Font("Arial", Font.BOLD, 10);

        // Bouton Effacer
        JButton effacer = new JButton("Effacer");
        effacer.setBounds(500, 700, 100, 50);
        effacer.setFont(font);
        effacer.addActionListener(e -> {
            toutEffacer();
            drawPanel.repaint(); // Redessiner
        });
        this.add(effacer);

        // Bouton Gomme
        JButton gomme = new JButton("Gomme");
        gomme.setBounds(610, 700, 100, 50);
        gomme.setFont(font);
        gomme.addActionListener(e -> {
            efface = true; // Activer le mode gomme
        });
        this.add(gomme);

        // Bouton pour choisir une couleur
        JButton choisirCouleur = new JButton("Choisir Couleur");
        choisirCouleur.setBounds(720, 700, 150, 50);
        choisirCouleur.setFont(font);
        choisirCouleur.addActionListener(e -> {
            // Ouvrir un JColorChooser pour choisir une couleur
            Color color = JColorChooser.showDialog(this, "Choisir une couleur", couleurPinceau);
            if (color != null) {
                couleurPinceau = color; // Mettre à jour la couleur actuelle
            }
        });
        this.add(choisirCouleur);

        // Boutons pour des couleurs spécifiques (si besoin)
        JButton rouge = new JButton("Rouge");
        rouge.setBounds(880, 700, 100, 50);
        rouge.setFont(font);
        rouge.setForeground(Color.RED);
        rouge.addActionListener(e -> {
            couleurPinceau = Color.RED; // Couleur rouge
            efface = false;        // Désactiver le mode gomme
        });
        this.add(rouge);

        JButton vert = new JButton("Vert");
        vert.setBounds(990, 700, 100, 50);
        vert.setFont(font);
        vert.setForeground(Color.GREEN);
        vert.addActionListener(e -> {
            couleurPinceau = Color.GREEN; // Couleur verte
            efface = false;          // Désactiver le mode gomme
        });
        this.add(vert);

        JButton bleu = new JButton("Bleu");
        bleu.setBounds(1100, 700, 100, 50);
        bleu.setFont(font);
        bleu.setForeground(Color.BLUE);
        bleu.addActionListener(e -> {
            couleurPinceau = Color.BLUE; // Couleur bleue
            efface = false;         // Désactiver le mode gomme
        });
        this.add(bleu);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    // Méthode pour dessiner
    private void dessin(int x, int y) {
        if (outil != null) {
            if (efface) {
                outil.setColor(Color.WHITE); // Gomme (fond blanc)
                outil.fillRect(x - tailleGomme / 2, y - tailleGomme / 2, tailleGomme, tailleGomme); // Gomme plus grande
            } else {
                outil.setColor(couleurPinceau); // Couleur sélectionnée
                outil.fillRect(x - taillePinceau / 2, y - taillePinceau / 2, taillePinceau, taillePinceau); // Pinceau 10x10
            }
            repaint(); // Mettre à jour l'affichage
        }
    }

    // Méthode pour effacer tout le dessin
    private void toutEffacer() {
        if (outil != null) {
            outil.setColor(Color.WHITE); // Couleur du fond
            outil.fillRect(0, 0, zondeDessin.getWidth(), zondeDessin.getHeight());
        }
    }
}
