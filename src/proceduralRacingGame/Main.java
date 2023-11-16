package proceduralRacingGame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.Timer;

import javax.swing.*;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: GameEngine - Final Project
 * Description: Main Program To Start Game
 */

public class Main extends JFrame implements ActionListener, KeyListener{
	private static CollisionManager collisionManager; // the object managing collision
	private static RenderManager renderManager; // the object managing rendering
	private static GameManager gameManager; // the object managing game state
	
	private static Timer timer; // the timer updating the game
	
	private static List<GameObject> gameObjects; // gameObjects that exist in the game

    private final int DELAY = 10; // update delay
	
    /**
     * Creates GameEngin with timer
     */
	public Main() {
		 timer = new Timer(DELAY, this);
	      timer.start();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main ex = new Main();
				ex.addComponents();
	            ex.pack();
	            ex.setVisible(true);
			}
		});
	}
	
	/***
	 * Adds components after GameEngine is instantiated to pass itself to managers
	 */
	private void addComponents() {
		gameObjects = new ArrayList<GameObject>();
		GameObject.setGameEngine(this);
		
		renderManager = new RenderManager();
		renderManager.addKeyListener(this);
		add(renderManager);
		
		collisionManager = new CollisionManager();
		
		gameManager = new GameManager();
		
		setPreferredSize(new Dimension(1920, 1080));
		
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	}

	/**
	 * triggered on key typed(only letters)
	 */
	@Override
    public void keyTyped(KeyEvent e) {
		Input.updateInput(e, KeyState.TYPED);
    }


	/**
	 * triggered on key press
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		Input.updateInput(e, KeyState.PRESSED);
	}

	/**
	 * triggered on key release
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		Input.updateInput(e, KeyState.RELEASED);
	}


	/**
	 * Creates the game object and adds references to managers
	 * @param gameObject GameObject to create
	 */
	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
		renderManager.addRenderer(gameObject.getRenderer());
		if(gameObject.getCollider()!=null) // only adds collider if applicable
			collisionManager.addCollider(gameObject.getCollider());
	}

	/**
	 * Destroys the game object and its references
	 * @param gameObject GameObject to destroy
	 */
	public void destroyObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
		renderManager.removeRenderer(gameObject.getRenderer());
		collisionManager.removeCollider(gameObject.getCollider());
		if(collisionManager.player == gameObject.getCollider())
			collisionManager.player = null;
	}
	
	/***
	 * Called from timer
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gameManager.update();
		collisionManager.update();
		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).update();
		}
		repaint();
	}
	
	
	
	
	
	
	
	
	
	
}
