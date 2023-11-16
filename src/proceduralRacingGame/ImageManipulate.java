package proceduralRacingGame;

import java.awt.*;
import java.awt.image.BufferedImage;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: ImageManipulate - Final Project
 * Description: Contains manipulation function for images
 */
public class ImageManipulate {
	/**
	 * Resizes image
	 * @param img Image to size
	 * @param dimensnion Dimension to change to
	 * @return New Image in the dimension
	 */
	public static BufferedImage resize(BufferedImage img, Vector2 dimensnion) { 
	    Image tmp = img.getScaledInstance((int)dimensnion.x, (int)dimensnion.y, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage((int)dimensnion.x, (int)dimensnion.y, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
}
