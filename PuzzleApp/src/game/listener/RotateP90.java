package game.listener;

import game.model.DataMatrix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.model.ChangePiece.coups;
import static game.model.DataMatrix.gameStatus;
import static main.Main.secondCounter;

public class RotateP90 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DataMatrix.rotatePlus90();
        coups++;
        gameStatus = true;
        secondCounter.start();
    }
}
