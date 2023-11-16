package proceduralRacingGame;
/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: GameObject - Final Project
 * Description: Base Game Object for anything that shows on screen
 */
public class GameObject implements Updateable{
	private Vector2 coords; // coordinates of object relative to screen centre
	private boolean isStatic; // does object move on screen
	private CollisionDetector collider; // collider of object
	private Renderer renderer; // renderer of object
	private static Main gameEngine; // gameEngine of object
	String name; // for debugging purposes
	
	GameObject(String name, Vector2 coords, boolean isStatic, CollisionDetector collider, Renderer renderer) {
		this.name = name;
		this.coords = coords;
		this.isStatic = isStatic;
		this.collider = collider;
		this.renderer = renderer;
		gameEngine.addGameObject(this);
	}
	

	public CollisionDetector getCollider() {
		return collider;
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return coords.x;
	}
	/**
	 * @param x: the x to set
	 */
	public void setX(double x) {
		if (!isStatic)
			collider.collisionCentre.x = x; //collision centre should usually match object centre
			renderer.centre.x = x;
			coords.x = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return coords.y;
	}
	/**
	 * @param y: the y to set
	 */
	public void setY(double y) {
		if (!isStatic)
			coords.y = y;
			renderer.centre.y = y;
			collider.collisionCentre.y = y; //collision centre should usually match object centre
	}

	/***
	 * Sends engine to destroy all references to the object
	 */
	public void destroy() {
		gameEngine.destroyObject(this);
	}
	
	
	/**
	 * @param gameEngine the gameEngine to set
	 */
	public static void setGameEngine(Main gameEngine) {
		GameObject.gameEngine = gameEngine;
	}

	/**
	 * @return the renderer
	 */
	public Renderer getRenderer() {
		return renderer;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
