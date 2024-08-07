package selendroid;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Demo {
    public static void main(String[] args) {
        int width = 400;
        int height = 200;

        // Create a buffered image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Get the graphics context of the buffered image
        Graphics2D g2d = image.createGraphics();

        // Set rendering hints for smoother text
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color
        Color backgroundColor = new Color(30, 30, 30); // Dark background
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, width, height);

        // Set text color and font
        Color textColor = new Color(0, 255, 255); // Cyan color
        g2d.setColor(textColor);

        try {
            // Load futuristic font using absolute path
            String fontFilePath = "C:\\path\\to\\FuturisticFont.ttf";
            File fontFile = new File(fontFilePath);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.BOLD, 60);
            g2d.setFont(font);
        } catch (FontFormatException | IOException e) {
            System.out.println("Error loading font: " + e.getMessage());
            return;
        }


        // Draw the text with gradient effect
        String text = "Shubham";
        int textWidth = g2d.getFontMetrics().stringWidth(text);
        int x = (width - textWidth) / 2;
        int y = height / 2;

        GradientPaint gradient = new GradientPaint(x, y, textColor, x + textWidth, y, Color.WHITE);
        g2d.setPaint(gradient);
        g2d.drawString(text, x, y);

        // Dispose graphics context
        g2d.dispose();

        // Save the image to a file
        try {
            File output = new File("C:\\Users\\Admin\\Desktop\\apk\\futuristic_shubham_image.png");
            ImageIO.write(image, "png", output);
            System.out.println("Image created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
        }
    }
}
