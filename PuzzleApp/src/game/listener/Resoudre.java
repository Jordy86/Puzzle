package game.listener;

import game.model.DataMatrix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resoudre implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DataMatrix.resoudre();
    }
}
