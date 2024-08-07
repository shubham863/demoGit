package TaskEase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.PageSegMode;

public class Tesserect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File imageFile = new File("C:\\Users\\Admin\\Desktop\\apk\\image.jpeg"); // Replace with the path to your image file

        ITesseract instance = new Tesseract();
        
        List<String> words = new ArrayList<>();

        instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Tesseract data directory (can be empty or null if tessdata is in the system's PATH)
        try {
        	  String result = instance.doOCR(imageFile);
              String[] wordArray = result.split("\\s+");

              for (String word : wordArray) {
                  words.add(word);
              }
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        
        for (String word : words) {
            System.out.println(word);
        }

	}

}
