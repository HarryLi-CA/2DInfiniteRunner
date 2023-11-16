package proceduralRacingGame;

import java.awt.*;
import java.awt.geom.*;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: LineRenderer - Final Project
 * Description: Renders line
 */
public class LineRenderer extends Renderer{
	private final int length;

	public LineRenderer(Vector2 centre, int priority, int length) {
		super(centre, priority);
		this.length = length;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics2D g2d, Vector2 centreDraw) {
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);
        AffineTransform at
        = AffineTransform.getTranslateInstance(centreDraw.x, centreDraw.y);
        g2d.draw(at.createTransformedShape(new Line2D.Double(-length/2,centre.y,length/2,centre.y)));
	}
	
}
