package proceduralRacingGame;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: RectnangleCollisionDetector - Final Project
 * Description: Checks with other colliders if they intersect with rectangle bounding box
 */

public class RectangleCollisionDetector extends CollisionDetector {
	private Vector2 leftBottom; // left bottom corner, both corners read-only due to the specific game not having objects with changing sizes
	private Vector2 rightTop; // right bottom corner
	
	/*****
	 * Readies basic parameters into useful values
	 * @param isPlayerVehicle 
	 * @param width: the width of the rectangle(integer)
	 * @param height: the height of the rectangle(integer)
	 */
	public RectangleCollisionDetector(Vector2 collisionCentre, Vector2 dimension, boolean isPlayerVehicle) {
		super(collisionCentre, isPlayerVehicle);
		
		leftBottom= new Vector2(-dimension.x/2,-dimension.y/2);

		rightTop = new Vector2(dimension.x/2,dimension.y/2);
	}
	
	
	/****
	 * 
	 */
	@Override
	public boolean checkOverlap(RectangleCollisionDetector player) {
		boolean overlapX = player.leftBottom.x + player.collisionCentre.x <= rightTop.x + collisionCentre.x &&
				leftBottom.x + collisionCentre.x <= player.rightTop.x + player.collisionCentre.x; // checks if overlap when only projecting on the x axis
		boolean overlapY = player.leftBottom.y + player.collisionCentre.y <= rightTop.y + collisionCentre.y &&
				leftBottom.y + collisionCentre.y <= player.rightTop.y + player.collisionCentre.y; // checks if overlap when only projecting on the y axis
		return overlapX && overlapY;
	}

	/**
	 * @return the leftBottom
	 */
	public Vector2 getLeftBottom() {
		return leftBottom;
	}

	/**
	 * @return the rightTop
	 */
	public Vector2 getRightTop() {
		return rightTop;
	}
	
}
