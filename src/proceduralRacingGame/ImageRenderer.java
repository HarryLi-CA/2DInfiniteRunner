package proceduralRacingGame;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: Image Renderer - Final Project
 * Description: Renders Images
 */
public class ImageRenderer extends Renderer{
	final BufferedImage img; // image to render
	
	public ImageRenderer(Vector2 centre, int priority, BufferedImage img, Vector2 dimension) {
		super(centre, priority);
		this.img = ImageManipulate.resize(img, dimension);
	}

	@Override
	public void render(Graphics2D g2d, Vector2 centreDraw) {
	    g2d.drawImage(img, (int)centreDraw.x - img.getWidth()/2 + (int)centre.x, (int)centreDraw.y - img.getHeight()/2 + (int)centre.y, null);
	}

}
