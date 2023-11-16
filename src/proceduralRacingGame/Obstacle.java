package proceduralRacingGame;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: Obstacle - Final Project
 * Description: Prefab for cone obstacle 
 */
public class Obstacle extends GameObject {
	private static int speed = 2;
	private static boolean isMoving = true;
	
	Obstacle(String name,Vector2 coords, Vector2 dimension) throws IOException {
		super(name, coords, false, new RectangleCollisionDetector(coords, dimension, false), 
				new ImageRenderer(coords, 1, ImageIO.read(new File("cone.png")), dimension));
	}
	
	public static void setSpeed(int speed) {
		Obstacle.speed = speed;
	}

	/**
	 * @param isMoving the isMoving to set
	 */
	public static void setMoving(boolean isMoving) {
		Obstacle.isMoving = isMoving;
	}
	
	@Override
	public void update() {
		if(isMoving)
			setX(getX()-speed);
	}
	
}
