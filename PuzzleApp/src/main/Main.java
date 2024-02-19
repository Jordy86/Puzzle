package main;

import game.affichage.Fenetre;
import game.model.ImageProcess;
import game.model.SecondCounter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static SecondCounter secondCounter = new SecondCounter();
    public static JLabel label = new JLabel("00:00:00");

    public static void main(String[] args) throws Exception {
        System.out.println("Lunching Puzzle ...");

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        File choose;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            choose = fileChooser.getSelectedFile();
        }else {
            throw new RuntimeException("Must choose file");
        }

        int row = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez une row:"));
        int col = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez une col:"));

        ImageProcess.processImage(choose.getAbsolutePath(), row, col);

        BufferedImage image = ImageIO.read(choose);

        new Fenetre(row, col, image.getWidth(), image.getHeight());
    }
}
