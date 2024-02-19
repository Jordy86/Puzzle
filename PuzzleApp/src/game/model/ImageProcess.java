package game.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageProcess {

    public static String outDir = "F:\\PuzzleApp\\data\\";

    public static int[] getRowCols(File file) throws NumberFormatException, ArrayIndexOutOfBoundsException {
        String path = file.getName();
        String[] parts = path.split("_");

        int[] result = new int[2];
        if (parts.length >= 2) {
            result[0] = Integer.parseInt(parts[0].substring(4));
            result[1] = Integer.parseInt(parts[1].split("\\.")[0]);
        }
        return result;
    }

    public static void processImage (String inputImagePath, int rows, int cols) throws Exception {
        File file = new File(outDir);
        deleteRecursive(file);
        file.mkdir();

        BufferedImage inputImage = ImageIO.read(new File(inputImagePath));

        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        int tileWidth = width / cols;
        int tileHeight = height / rows;

        BufferedImage subImage;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                subImage  = inputImage.getSubimage(col * tileWidth, row * tileHeight, tileWidth, tileHeight);
                String outputFileName = outDir + "part" + row + "_" + col + ".png";
                ImageIO.write(subImage, "png", new File(outputFileName));
            }
        }
    }

    private static void deleteRecursive(File fichierOuDossier) {
        if (fichierOuDossier.isDirectory()) {
            File[] fichiers = fichierOuDossier.listFiles();
            if (fichiers != null) {
                for (File fichier : fichiers) {
                    deleteRecursive(fichier);
                }
            }
        }
        fichierOuDossier.delete();
    }
}
