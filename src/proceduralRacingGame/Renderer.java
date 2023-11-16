package proceduralRacingGame;

import java.awt.*;
/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: Renderer - Final Project
 * Description: abstract class to render gameobjects on screen
 */

public abstract class Renderer implements Comparable<Renderer>{
	Vector2 centre;
	int priority;
	
	public Renderer(Vector2 centre, int priority) {
		this.centre = centre;
		this.priority = priority;
	}
	
	public int compareTo(Renderer rend) {
		return priority - rend.priority;
	}
	
	public abstract void render(Graphics2D g2d, Vector2 centreDraw);
}
