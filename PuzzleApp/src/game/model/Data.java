package game.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Data {
    private String src;
    private int row;
    private int col;
    private Image image;

    public Data(String src, int row, int col) throws IOException {
        this.setSrc(src);
        this.setRow(row);
        this.setCol(col);
        this.image = ImageIO.read(new File(src));

    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
