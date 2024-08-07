package TaskEase;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Tesserect3 {
	    public static void main(String[] args) {
			File imageFile = new File("C:\\Users\\Admin\\Desktop\\apk\\up.jpeg"); // Replace with the path to your image file
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
	        
	        Set<String> dictionary = loadDictionary("C:\\Users\\Admin\\Desktop\\apk\\dictionary.txt"); // Load dictionary from file
	        int matchCount = 0;
	        int mismatchCount = 0;


	        for (String word : words) {
	        	
	        	String cleanedWord = word.replaceAll("[\\s,\\.]", "");
                System.out.println(cleanedWord+" ");

	            if (dictionary.contains(cleanedWord.toLowerCase())) {
	                matchCount++;
	            } else {

	                mismatchCount++;
	            }
	        }

	        if (matchCount > mismatchCount) {
	            System.out.println("Proper image");
	        } else {
	            System.out.println("Flipped image");
	        }
	        System.out.println("matchCount - "+matchCount+" "+"mismatchCount - "+mismatchCount);
	    }

	    private static Set<String> loadDictionary(String filePath) {
	        Set<String> dictionary = new HashSet<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                dictionary.add(line.trim().toLowerCase());
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return dictionary;
	    }
	}



