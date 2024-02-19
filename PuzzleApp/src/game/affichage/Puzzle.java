package game.affichage;


import game.listener.ChangePieceListener;
import game.model.Data;
import game.model.DataMatrix;
import game.model.ImageProcess;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static game.model.ChangePiece.coups;
import static game.model.ImageProcess.outDir;
import static main.Main.secondCounter;

public class Puzzle extends JPanel {

    private final int cellWidth;
    private final int cellHeight;

    private int count = 0;
    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        for (int i = 0; i < DataMatrix.getMatrix().length; i++ ) {
            for (int j = 0; j<DataMatrix.getMatrix()[i].length; j++) {
                g.drawImage(DataMatrix.getMatrix()[i][j].getImage(), (j * cellWidth) +(j*3) , (i * cellHeight) +(i*3), cellWidth, cellHeight, null);
            }
        }

        if (DataMatrix.isWin()) {
            secondCounter.stop();

            if (count == 100 ) {
                JOptionPane.showMessageDialog(null, "Gagner avec " +coups +"\n"+secondCounter.secondsToTime(), "Gagner", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            count++;

        }

        repaint();
    }

    public Puzzle(int row, int col, int im_width, int im_height) throws IOException {
        Data[][] matrix = new Data[row][col];
        int r_temp;
        int c_temp;
        for (File f : Objects.requireNonNull(new File(outDir).listFiles())) {
            r_temp = ImageProcess.getRowCols(f)[0];
            c_temp = ImageProcess.getRowCols(f)[1];
            matrix[r_temp][c_temp] = new Data(outDir + f.getName(), r_temp, c_temp);
        }
        DataMatrix.setMatrix(matrix);

        int proportion = im_width/im_height;
        int w = 1000;
        int h = w / proportion;

        if (h > 700) {
            h = 700 ;
            w = h * proportion;
        }
        cellWidth = w / col;
        cellHeight = h / row;

        this.setBounds(0, 0, w, h);
        this.addMouseListener(new ChangePieceListener(cellWidth, cellHeight));
    }
}
