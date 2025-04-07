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
    private BufferedImage canvas;

    // Outil pour dessiner sur le canvas
    private Graphics2D g2d;

    // Couleur actuelle du pinceau (par défaut : rouge)
    private Color currentColor = Color.RED;

    // Indique si on est en mode gomme ou non
    private boolean isErasing = false;

    // Taille du pinceau en pixels
    private int brushSize = 10;

    // Taille de la gomme en pixels
    private int eraserSize = 30;

    // Constructeur principal
    public ArdoiseFacile(JFrame frame) {
        this.setLayout(null); // Disposition manuelle des composants

        // Dimensions du canvas (ardoise)
        int canvasWidth = 1920;
        int canvasHeight = 680;

        // Création du canvas avec fond transparent (ARGB)
        canvas = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics(); // Récupère le contexte graphique

        // Initialise le fond en blanc
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, canvasWidth, canvasHeight);

        // Panel pour dessiner, relié au canvas
        JPanel drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(canvas, 0, 0, null); // Affiche l'image dessinée
            }
        };

        // Position et taille du panneau de dessin
        drawPanel.setBounds(0, 0, canvasWidth, canvasHeight);
        drawPanel.setBackground(Color.WHITE);

        // Quand on clique, on dessine à l'endroit cliqué
        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
        });

        // Quand on glisse la souris, on continue de dessiner
        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
        });

        this.add(drawPanel); // Ajoute le panneau de dessin au composant principal

        // Police utilisée pour les boutons
        Font font = new Font("Arial", Font.BOLD, 10);

        // === Bouton : Effacer ===
        JButton effacer = new JButton("Effacer");
        effacer.setBounds(500, 700, 100, 50);
        effacer.setFont(font);
        effacer.addActionListener(e -> {
            clearCanvas();       // Vide le canvas
            drawPanel.repaint(); // Redessine l'écran
        });
        this.add(effacer);

        // === Bouton : Gomme ===
        JButton gomme = new JButton("Gomme");
        gomme.setBounds(610, 700, 100, 50);
        gomme.setFont(font);
        gomme.addActionListener(e -> {
            isErasing = true; // Active le mode gomme
        });
        this.add(gomme);

        // === Bouton : Rouge ===
        JButton rouge = new JButton("Rouge");
        rouge.setBounds(720, 700, 100, 50);
        rouge.setFont(font);
        rouge.setForeground(Color.RED); // Texte en rouge
        rouge.addActionListener(e -> {
            currentColor = Color.RED; // Change la couleur du pinceau
            isErasing = false;        // Désactive la gomme
        });
        this.add(rouge);

        // === Bouton : Vert ===
        JButton vert = new JButton("Vert");
        vert.setBounds(830, 700, 100, 50);
        vert.setFont(font);
        vert.setForeground(Color.GREEN);
        vert.addActionListener(e -> {
            currentColor = Color.GREEN;
            isErasing = false;
        });
        this.add(vert);

        // === Bouton : Bleu ===
        JButton bleu = new JButton("Bleu");
        bleu.setBounds(940, 700, 100, 50);
        bleu.setFont(font);
        bleu.setForeground(Color.BLUE);
        bleu.addActionListener(e -> {
            currentColor = Color.BLUE;
            isErasing = false;
        });
        this.add(bleu);

        // Met la fenêtre en plein écran
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    // Méthode pour dessiner ou gommer à une position donnée
    private void draw(int x, int y) {
        if (g2d != null) {
            if (isErasing) {
                // Dessine un rectangle blanc pour effacer
                g2d.setColor(Color.WHITE);
                g2d.fillRect(x - eraserSize / 2, y - eraserSize / 2, eraserSize, eraserSize);
            } else {
                // Dessine un rectangle de la couleur actuelle
                g2d.setColor(currentColor);
                g2d.fillRect(x - brushSize / 2, y - brushSize / 2, brushSize, brushSize);
            }
            repaint(); // Redessine l'écran après le trait
        }
    }

    // Efface complètement le canvas en remplissant de blanc
    private void clearCanvas() {
        if (g2d != null) {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }
}
