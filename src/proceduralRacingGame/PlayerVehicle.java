package proceduralRacingGame;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: PlayerVehicle - Final Project
 * Description: Prefab for player vehicle
 */
public class PlayerVehicle extends GameObject {

	GameManager gameManager; // the game manager
	public boolean playerMoveable = true; // if player allowed to move
	
	final static double MOVEMENTMODIFIER = 8;
	final static int KNOCKBACK = 5;
	
	PlayerVehicle(String name, Vector2 coords, Vector2 dimension, GameManager gameManager) throws IOException {
		super(name, coords, false, new RectangleCollisionDetector(coords, dimension, true), 
				new ImageRenderer(coords, -1, ImageIO.read(new File("car.png")), dimension));
		this.gameManager = gameManager;
	}
	
	@Override
	public void update() {
		if(playerMoveable && getCollider().isCollided) {
			playerMoveable = false;
			gameManager.endGame();
			setX(getX() - KNOCKBACK);
			return;
		}
		if(playerMoveable)
			setY(getY() + MOVEMENTMODIFIER * Input.getMovementState());
	}

}
