package game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class DataMatrix {
    public static boolean gameStatus;
    private static Data[][] matrix;

    public static void resoudre() {
        Data[][] temp = new Data[matrix.length][matrix[0].length];

        for (Data[] data : matrix) {
            for (Data d : data) {
                temp[d.getRow()][d.getCol()] = d;
            }
        }
        setMatrix(temp);
    }

    private static Data[][] transpose() {
        Data[][] data_temp = new Data[matrix[0].length][matrix.length];
        Data[] temp;

        for (int i = 0; i < matrix[0].length; i++) {
            temp = new Data[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                temp[j] = matrix[j][i];
            }

            data_temp[i] = temp;
        }
        return data_temp;
    }

    public static void rotateMinus90() {
        int row = DataMatrix.getMatrix().length;
        int col = DataMatrix.getMatrix()[0].length;

        Data[][] data_transpose = transpose();
        Data[][] result = new Data[data_transpose.length][data_transpose[0].length];

        for (int i = 0; i < data_transpose.length; i++) {
            result[i] = data_transpose[data_transpose.length - 1 -i];
        }

        if (row != col) {
            List<Data> flatList = new ArrayList<>();
            for (Data[] data : result) {
                Collections.addAll(flatList, data);
            }

            int ind = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = flatList.get(ind);
                    ind++;
                }
            }
            setMatrix(matrix);
        }else {
            setMatrix(result);
        }


    }

    public static void rotatePlus90() {
        int row = DataMatrix.getMatrix().length;
        int col = DataMatrix.getMatrix()[0].length;

        Data[][] data_transpose = transpose();
        Data[][] result = new Data[data_transpose.length][data_transpose[0].length];

        int i = 0;
        for (Data[] data : data_transpose) {
            result[i] = inverser(data);
            i++;
        }

        if (row != col) {

            List<Data> flatList = new ArrayList<>();
            for (Data[] data : result) {
                Collections.addAll(flatList, data);
            }
            flatList = List.of(inverser(flatList.toArray(new Data[0])));
            int ind = 0;
            for (i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = flatList.get(ind);
                    ind++;
                }
            }

            setMatrix(matrix);
        }else {
            setMatrix(result);
        }

    }

    private static Data[] inverser(Data[] data) {
        Data[] result = new Data[data.length];

        for (int i = 0; i< result.length; i++) {
            result[result.length -i -1] = data[i];
        }

        return result;
    }

    public static boolean isWin() {
        if (gameStatus) {
            for (int i=0; i< matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j].getRow() != i || matrix[i][j].getCol() != j) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void shuffle() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Data> flatList = new ArrayList<>();
        for (Data[] data : matrix) {
            Collections.addAll(flatList, data);
        }
        Collections.shuffle(flatList, new Random());

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = flatList.get(index);
                index++;
            }
        }
    }

    public static Data[][] getMatrix() {
        return matrix;
    }

    public static void setMatrix(Data[][] matrix) {
        DataMatrix.matrix = matrix;
    }
}
