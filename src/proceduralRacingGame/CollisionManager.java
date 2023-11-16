package proceduralRacingGame;

import java.util.*;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: CollisionManager - Final Project
 * Description: Collision Manager to manager collision detection
 */

public class CollisionManager implements Updateable{
	RectangleCollisionDetector player; // only object to check if colliding with other objects
	List<CollisionDetector> colliders; // colliders available
	
	public CollisionManager() {
		colliders = new ArrayList<CollisionDetector>();
	}
	
	public void findPlayer() {
		for (int i = 0; i < colliders.size(); i++) {
			if(colliders.get(i).isPlayer()) {
				player = (RectangleCollisionDetector) colliders.get(i);
			}
		}
	}
	
	/***
	 * Checks colliders
	 */
	public void update() {
		if(player == null)
			findPlayer();
		else {
			for (int i = 0; i < colliders.size(); i++) {
				if(!colliders.get(i).isPlayer() && colliders.get(i).checkOverlap(player)){
					colliders.get(i).isCollided = true;
					player.isCollided = true;
					return;
				}
			}
		}
	}
	
	/**
	 * adds collider
	 * @param collider Collider to add
	 */
	public void addCollider(CollisionDetector collider) {
		colliders.add(collider);
	}
	
	/***
	 * removes collider
	 * @param collider Collider to remove
	 */
	public void removeCollider(CollisionDetector collider) {
		colliders.remove(collider);
	}
}
