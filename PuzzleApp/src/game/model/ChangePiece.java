package game.model;

import static game.model.DataMatrix.gameStatus;
import static main.Main.secondCounter;

public class ChangePiece {
    public static int coups = 0;

    private static int[] coord_1;
    private static int[] coord_2;

    public static void addCoord(int row, int col) {
        secondCounter.start();

        if (coord_1 == null) {
            coord_1 = new int[2];
            coord_1[0] = row;
            coord_1[1] = col;
        } else if (coord_2 == null) {
            coord_2 = new int[2];
            coord_2[0] = row;
            coord_2[1] = col;

            Data temp = DataMatrix.getMatrix()[coord_1[0]][coord_1[1]];
            DataMatrix.getMatrix()[coord_1[0]][coord_1[1]] = DataMatrix.getMatrix()[coord_2[0]][coord_2[1]];
            DataMatrix.getMatrix()[coord_2[0]][coord_2[1]] = temp;
            initCoord();
            gameStatus = true;
            coups++;
        }
    }

    private static void initCoord() {
        coord_1 = null;
        coord_2 = null;
    }
}
