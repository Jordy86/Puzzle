package game.listener;

import game.model.DataMatrix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.model.ChangePiece.coups;
import static game.model.DataMatrix.gameStatus;
import static main.Main.secondCounter;

public class Melanger implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DataMatrix.shuffle();
        gameStatus = true;
        coups++;
        secondCounter.start();
    }
}
