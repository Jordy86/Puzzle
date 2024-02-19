package game.affichage;

import game.listener.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static main.Main.label;

public class Fenetre extends JFrame {

    public Fenetre(int row, int col,int im_width, int im_height) throws IOException {
        this.setLayout(null);
        this.setSize(1000, 800);
        this.getContentPane().setBackground(new Color(200, 173, 127));


        Button melanger = new Button("Melanger", 10, 710, 100, 25);
        Button resoudre = new Button("Resoudre", 120, 710, 100, 25);
        Button m90 = new Button("Moins 90", 240, 710, 100, 25);
        Button p90 = new Button("Plus 90", 360, 710, 100, 25);
        Button p180 = new Button("Plus 180", 480, 710, 100, 25);
        label.setBounds(480, 710, 100, 25);

        melanger.addActionListener(new Melanger());
        resoudre.addActionListener(new Resoudre());
        m90.addActionListener(new RotateM90());
        p90.addActionListener(new RotateP90());
        p180.addActionListener(new RotateP180());

        this.add(new Puzzle(row, col, im_width, im_height));
        this.add(melanger);
        this.add(resoudre);
        this.add(m90);
        this.add(p90);
        this.add(p180);
        this.add(label);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
