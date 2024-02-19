package game.listener;


import game.model.ChangePiece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePieceListener extends MouseAdapter {
    int cellWidth;
    int cellHeight;

    public ChangePieceListener(int cellWidth, int cellHeight) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        int mouseX = e.getX();
        int mouseY = e.getY();
        int clickedI = mouseY / (cellHeight + 3);
        int clickedJ = mouseX / (cellWidth + 3);

        /*System.out.println(clickedI);
        System.out.println(clickedJ);*/

        ChangePiece.addCoord(clickedI, clickedJ);
    }


}
