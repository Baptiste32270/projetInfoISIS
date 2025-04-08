/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ArdoiseFacile extends JPanel {

    // Zone de dessin (image mémoire)
    private BufferedImage zoneDessin;

    // Outil pour dessiner sur le canvas
    private Graphics2D outil;

    // Couleur actuelle du pinceau (par défaut : rouge)
    private Color couleurPinceau = Color.RED;

    // Indique si on est en mode gomme ou non
    private boolean efface = false;

    // Taille du pinceau en pixels
    private int taillePinceau = 10;

    // Taille de la gomme en pixels
    private int taileGomme = 30;

    // Constructeur principal
    public ArdoiseFacile(JFrame frame) {
        this.setLayout(null); // Disposition manuelle des composants

        // Dimensions du canvas (ardoise)
        int canvasWidth = 1920;
        int canvasHeight = 680;

        // Création du canvas avec fond transparent (ARGB)
        zoneDessin = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        outil = zoneDessin.createGraphics(); // Récupère le contexte graphique

        // Initialise le fond en blanc
        outil.setColor(Color.WHITE);
        outil.fillRect(0, 0, canvasWidth, canvasHeight);

        // Panel pour dessiner, relié au canvas
        JPanel zoneDeDessin = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(zoneDessin, 0, 0, null); // Affiche l'image dessinée
            }
        };

        // Position et taille du panneau de dessin
        zoneDeDessin.setBounds(0, 0, canvasWidth, canvasHeight);
        zoneDeDessin.setBackground(Color.WHITE);

        // Quand on clique, on dessine à l'endroit cliqué
        zoneDeDessin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dessin(e.getX(), e.getY());
            }
        });

        // Quand on glisse la souris, on continue de dessiner
        zoneDeDessin.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dessin(e.getX(), e.getY());
            }
        });

        this.add(zoneDeDessin); // Ajoute le panneau de dessin au composant principal

        // Police utilisée pour les boutons
        Font font = new Font("Arial", Font.BOLD, 10);

        // === Bouton : Effacer ===
        JButton effacer = new JButton("Effacer");
        effacer.setBounds(500, 700, 100, 50);
        effacer.setFont(font);
        effacer.addActionListener(e -> {
            toutEffacer();       // Vide le canvas
            zoneDeDessin.repaint(); // Redessine l'écran
        });
        this.add(effacer);

        // === Bouton : Gomme ===
        JButton gomme = new JButton("Gomme");
        gomme.setBounds(610, 700, 100, 50);
        gomme.setFont(font);
        gomme.addActionListener(e -> {
            efface = true; // Active le mode gomme
        });
        this.add(gomme);

        // === Bouton : Rouge ===
        JButton rouge = new JButton("Rouge");
        rouge.setBounds(720, 700, 100, 50);
        rouge.setFont(font);
        rouge.setForeground(Color.RED); // Texte en rouge
        rouge.addActionListener(e -> {
            couleurPinceau = Color.RED; // Change la couleur du pinceau
            efface = false;        // Désactive la gomme
        });
        this.add(rouge);

        // === Bouton : Vert ===
        JButton vert = new JButton("Vert");
        vert.setBounds(830, 700, 100, 50);
        vert.setFont(font);
        vert.setForeground(Color.GREEN);
        vert.addActionListener(e -> {
            couleurPinceau = Color.GREEN;
            efface = false;
        });
        this.add(vert);

        // === Bouton : Bleu ===
        JButton bleu = new JButton("Bleu");
        bleu.setBounds(940, 700, 100, 50);
        bleu.setFont(font);
        bleu.setForeground(Color.BLUE);
        bleu.addActionListener(e -> {
            couleurPinceau = Color.BLUE;
            efface = false;
        });
        this.add(bleu);

        // Met la fenêtre en plein écran
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    // Méthode pour dessiner ou gommer à une position donnée
    private void dessin(int x, int y) {
        if (outil != null) {
            if (efface) {
                // Dessine un rectangle blanc pour effacer
                outil.setColor(Color.WHITE);
                outil.fillRect(x - taileGomme / 2, y - taileGomme / 2, taileGomme, taileGomme);
            } else {
                // Dessine un rectangle de la couleur actuelle
                outil.setColor(couleurPinceau);
                outil.fillRect(x - taillePinceau / 2, y - taillePinceau / 2, taillePinceau, taillePinceau);
            }
            repaint(); // Redessine l'écran après le trait
        }
    }

    // Efface complètement le canvas en remplissant de blanc
    private void toutEffacer() {
        if (outil != null) {
            outil.setColor(Color.WHITE);
            outil.fillRect(0, 0, zoneDessin.getWidth(), zoneDessin.getHeight());
        }
    }
}
