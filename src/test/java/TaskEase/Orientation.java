package TaskEase;

import java.util.Set;

import javax.imageio.ImageIO;

import java.util.HashSet;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class Orientation {
	public static void correctOrientation(FileRecord image) throws ImageProcessingException, IOException, MetadataException {
	    String typ = image.getFiletyp().split("/")[0]; // The file typ
	    if(typ.equals("image")) {
	      Metadata metadata = getImageMetadata(image);
	      if(metadata != null) {
	        if(metadata.containsDirectoryOfType(ExifIFD0Directory.class)) {
	          // Get the current orientation of the image
	          Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
	          int orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
	          
	          // Get the current width and height of the image
	          int[] imageSize = getImageSize(image);
	          int width = imageSize[0];
	          int height = imageSize[1];
	          
	          // Determine which correction is needed
	          AffineTransform t = new AffineTransform();
	          switch(orientation) {
	          case 1:
	            // no correction necessary skip and return the image
	            break;
	            case 2: // Flip X
	                t.scale(-1.0, 1.0);
	                t.translate(-width, 0);
	                transform(image, t);
	                break;
	            case 3: // PI rotation 
	                t.translate(width, height);
	                t.rotate(Math.PI);
	                transform(image, t);
	                break;
	            case 4: // Flip Y
	                t.scale(1.0, -1.0);
	                t.translate(0, -height);
	                transform(image, t);
	                break;
	            case 5: // - PI/2 and Flip X
	                t.rotate(-Math.PI / 2);
	                t.scale(-1.0, 1.0);
	                transform(image, t);
	                break;
	            case 6: // -PI/2 and -width
	                t.translate(height, 0);
	                t.rotate(Math.PI / 2);
	                transform(image, t);
	                break;
	            case 7: // PI/2 and Flip
	                t.scale(-1.0, 1.0);
	                t.translate(height, 0);
	                t.translate(0, width);
	                t.rotate(  3 * Math.PI / 2);
	                transform(image, t);
	                break;
	            case 8: // PI / 2
	                t.translate(0, width);
	                t.rotate(  3 * Math.PI / 2);
	                transform(image, t);
	                break;
	            }
	        }
	      }
	    }
	  }

	private static void transform(FileRecord image, AffineTransform transform) throws IOException {
	    String typ = image.getFiletyp().split("/")[0]; // The file typ
	    if(typ.equals("image")) {
	      // Create a buffered image of the current file
	      InputStream in = new ByteArrayInputStream(image.getFile());
	      BufferedImage bimage = ImageIO.read(in);
	      
	      // Create an transformation operation
	      AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
	      
	      // Create an instance of the resulting image, with the same width, height and image type than the referenced one
	      BufferedImage destinationImage = new BufferedImage( bimage.getWidth(), bimage.getHeight(), bimage.getType() );
	      op.filter(bimage, destinationImage);
	        
	        // Set the created image as new buffered image
	        image.setFile(getByteArray(destinationImage, image.getFilename()));
	    }
	  }

	public static int[] getImageSize(FileRecord image) throws IOException {
	    String typ = image.getFiletyp().split("/")[0]; // The file typ
	    if(typ.equals("image")) {
	      InputStream in = new ByteArrayInputStream(image.getFile());
	      BufferedImage bimg = ImageIO.read(in);
	      
	      int imageSize[] = {bimg.getWidth(), bimg.getHeight()};
	      
	      log.debug("Image size: "+bimg.getWidth()+"x"+bimg.getHeight());
	      
	      return imageSize;
	    }
	    
	    return null;
	  }

	private static byte[] getByteArray(BufferedImage image, String filename) throws IOException {
	    String formatName = "JPEG";
	    if(filename.contains(".")) {
	      String[] split = filename.split("\\.");
	      formatName = split[split.length-1];
	    }
	    
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write( image, formatName, baos );
	    baos.flush();
	    byte[] imageInByte = baos.toByteArray();
	    baos.close();
	    
	    return imageInByte;
	  }

	public static int[] getImageSize(FileRecord image) throws IOException {
	    String typ = image.getFiletyp().split("/")[0]; // The file typ
	    if(typ.equals("image")) {
	      InputStream in = new ByteArrayInputStream(image.getFile());
	      BufferedImage bimg = ImageIO.read(in);
	      
	      int imageSize[] = {bimg.getWidth(), bimg.getHeight()};
	      
	      log.debug("Image size: "+bimg.getWidth()+"x"+bimg.getHeight());
	      
	      return imageSize;
	    }
	    
	    return null;
	}
}
