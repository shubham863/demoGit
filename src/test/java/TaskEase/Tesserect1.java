package TaskEase;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Tesserect1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File imageFile = new File("C:\\Users\\Admin\\Desktop\\apk\\image2.jpeg"); // Replace with the path to your image file

        ITesseract instance = new Tesseract();

        instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Tesseract data directory (can be empty or null if tessdata is in the system's PATH)
        try {
            BufferedImage image = ImageIO.read(imageFile);
            int width = image.getWidth();
            int height = image.getHeight();
            double aspectRatio = (double) width / height;

            if (aspectRatio > 1) {
                System.out.println("Pages are mostly horizontal.");
            } else {
                System.out.println("Pages are mostly vertical.");
            }
        } catch (IOException e) {
            System.err.println("Error reading image: " + e.getMessage());
        }

	}

}
