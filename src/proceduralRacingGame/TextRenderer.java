package proceduralRacingGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: TextRenderer - Final Project
 * Description: Renders Text
 */

public class TextRenderer extends Renderer{
	String text; //text to render
	int fontSize; // font size to render at
	TextAlignment alignment; // alignment to render towards
	
	public TextRenderer(Vector2 centre, int priority, String text, int fontSize, TextAlignment alignment) {
		super(centre, priority);
		this.text = text;
		this.fontSize = fontSize;
		this.alignment = alignment;
	}

	@Override
	public void render(Graphics2D g2d, Vector2 centreDraw) {
	    g2d.setColor(Color.BLACK);
	    g2d.setFont(new Font( "SansSerif", Font.BOLD, fontSize ));
		g2d.drawString(text, (int)(centre.x + centreDraw.x-text.length()*fontSize*alignment.getAlignmentNeeded()), (int) (centre.y + (int)centreDraw.y));
	    g2d.setColor(Color.WHITE);
	}
	
	public void setText(String text) {
		this.text = text;
	}

}
