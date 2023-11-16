package proceduralRacingGame;


/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: CollisionDetector - Final Project
 * Description: Checks with other colliders if they intersect with bounding box
 */

public abstract class CollisionDetector {
	protected boolean isCollided; // if object collided
	private boolean isPlayer; // marks if player to allow for collision manager to calculate optimally
	public Vector2 collisionCentre; // the centre of collision box
	
	public CollisionDetector(Vector2 collisionCentre, boolean isPlayerVehicle) {
		this.collisionCentre = collisionCentre;
		isPlayer = isPlayerVehicle;
	}

	/**
	 * @return the isPlayer
	 */
	public boolean isPlayer() {
		return isPlayer;
	}
	
	/***
	 * @return isCollided
	 */
	public boolean getIsCollided() {
		return isCollided;
	}
	
	/***
	 * Checks if there is overlap between colliders
	 * @param player Player's CollisionDetector
	 * @return if overlaps
	 */
	public abstract boolean checkOverlap(RectangleCollisionDetector player);
}
