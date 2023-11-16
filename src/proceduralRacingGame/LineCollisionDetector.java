package proceduralRacingGame;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: LineCollisionDetector - Final Project
 * Description: Checks with other colliders if they intersect bounding box with line
 */
public class LineCollisionDetector extends CollisionDetector{
	
	public LineCollisionDetector(Vector2 collisionCentre) {
		super(collisionCentre, false);
	}
	
	@Override
	public boolean checkOverlap(RectangleCollisionDetector player) {
		if(player.getLeftBottom().y + player.collisionCentre.y < super.collisionCentre.y && player.getRightTop().y + player.collisionCentre.y >super.collisionCentre.y) {
			super.isCollided = true;
			return true;
		}
		
		return false;
	}
}
