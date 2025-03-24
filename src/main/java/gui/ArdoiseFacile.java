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
    private BufferedImage canvas; // Zone de dessin
    private Graphics2D g2d;       // Outil graphique pour dessiner
    private Color currentColor = Color.RED; // Couleur actuelle (par défaut : noir)
    private boolean isErasing = false;        // Mode gomme
    private int brushSize = 10;                // Taille du pinceau (10x10 pixels)
    private int eraserSize = 30;               // Taille de la gomme (30x30 pixels)

    public ArdoiseFacile() {
        this.setLayout(null);

        // Dimensions de l'ardoise
        int canvasWidth = 1920;
        int canvasHeight = 680;

        // Créer la zone de dessin (BufferedImage)
        canvas = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics();
        g2d.setColor(Color.WHITE); // Fond blanc
        g2d.fillRect(0, 0, canvasWidth, canvasHeight);

        // Panel pour dessiner
        JPanel drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(canvas, 0, 0, null); // Dessiner le contenu du canvas
            }
        };
        drawPanel.setBounds(0, 0, canvasWidth, canvasHeight);
        drawPanel.setBackground(Color.WHITE);
        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
        });
        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
        });
        this.add(drawPanel);

        // Barre d'outils (boutons)
        Font font = new Font("Arial", Font.BOLD, 10);

        JButton effacer = new JButton("Effacer");
        effacer.setBounds(500, 700, 100, 50);
        effacer.setFont(font);
        effacer.addActionListener(e -> {
            clearCanvas();
            drawPanel.repaint(); // Redessiner
        });
        this.add(effacer);

        JButton gomme = new JButton("Gomme");
        gomme.setBounds(610, 700, 100, 50);
        gomme.setFont(font);
        gomme.addActionListener(e -> {
            isErasing = true; // Activer le mode gomme
        });
        this.add(gomme);

        JButton rouge = new JButton("Rouge");
        rouge.setBounds(720, 700, 100, 50);
        rouge.setFont(font);
        rouge.setForeground(Color.RED);
        rouge.addActionListener(e -> {
            currentColor = Color.RED; // Couleur rouge
            isErasing = false;        // Désactiver le mode gomme
        });
        this.add(rouge);

        JButton vert = new JButton("Vert");
        vert.setBounds(830, 700, 100, 50);
        vert.setFont(font);
        vert.setForeground(Color.GREEN);
        vert.addActionListener(e -> {
            currentColor = Color.GREEN; // Couleur verte
            isErasing = false;          // Désactiver le mode gomme
        });
        this.add(vert);

        JButton bleu = new JButton("Bleu");
        bleu.setBounds(940, 700, 100, 50);
        bleu.setFont(font);
        bleu.setForeground(Color.BLUE);
        bleu.addActionListener(e -> {
            currentColor = Color.BLUE; // Couleur bleue
            isErasing = false;         // Désactiver le mode gomme
        });
        this.add(bleu);
    }

    // Méthode pour dessiner
    private void draw(int x, int y) {
        if (g2d != null) {
            if (isErasing) {
                g2d.setColor(Color.WHITE); // Gomme (fond blanc)
                g2d.fillRect(x - eraserSize / 2, y - eraserSize / 2, eraserSize, eraserSize); // Gomme plus grande
            } else {
                g2d.setColor(currentColor); // Couleur sélectionnée
                g2d.fillRect(x - brushSize / 2, y - brushSize / 2, brushSize, brushSize); // Pinceau 10x10
            }
            repaint(); // Mettre à jour l'affichage
        }
    }

    // Méthode pour effacer tout le canvas
    private void clearCanvas() {
        if (g2d != null) {
            g2d.setColor(Color.WHITE); // Couleur du fond
            g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }
}
