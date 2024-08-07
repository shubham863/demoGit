package TaskEase;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.text.TextObjectFactory;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.LanguageDetectionException;

import java.io.IOException;

public class LanguageDetectionExample {
    public static void main(String[] args) {
        String text = "Your input string here";

        // Language Detector initialization
        LanguageDetector languageDetector;
        try {
            languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                    .withProfiles(new LanguageProfileReader().readAllBuiltIn())
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Text object factory
        TextObjectFactory textObjectFactory = new TextObjectFactory();

        // Detect language
        com.optimaize.langdetect.Language detectedLanguage;
        try {
            detectedLanguage = languageDetector.detect(textObjectFactory.forText(text));
            System.out.println("Detected language: " + detectedLanguage);
        } catch (LanguageDetectionException e) {
            e.printStackTrace();
        }
    }
}
