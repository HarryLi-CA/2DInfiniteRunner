package proceduralRacingGame;

import java.io.*;
import java.util.Scanner;

import javax.swing.JLabel;
/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: GameManager - Final Project
 * Description: Game Manager to manager state of game
 */

public class GameManager implements Updateable{
	PlayerVehicle playerVehicle; // the player vehicle
	QueueLinkList obstacles; // the cones as obstacles
	Wall walls[]; // the upper and lower wall
	int score = 0; // the current score
	int highScore; // the high score
	
	Text gameStateText; //the text telling player to start/restart with enter key
	Text scoreText; // the text displaying the score(also time in ms since restart)
	Text highScoreText; // the text displaying the highScore
	
	boolean isGameEnded = true; // if game ended

	final static int SCORE_TEXT_FONT_SIZE = 20; // both scores' text size (both high and regular score size)
	final static int SCORE_TEXT_DISTANCE_FROM_WALL = 10; // both scores' horizontal distance from upper wall
	
	final static int GAME_STATE_FONT_SIZE = 40; // game state text's font size
	
	final static int WALL_DISTANCE_FROM_CENTRE = 300; // both walls' horizontal distance from centre
	
	final static int OBSTACLE_SIZE = 50; // obstacle's size
	final static int OBSTACLE_DENSITY = 300; // the period in milliseconds of when obstacles are created
	final static int OBSTACLE_REMOVAL_X_COORD = -700; // horizontal distance when obstacle should be removed from game to save collision and render time
	
	
	/********
	 * Creates GameObjects and Sets Up Scores
	 */
	public GameManager() {
		score = 0;
		highScore = getHighScore();
		
		walls = new Wall[2];
		walls[0] = new Wall("Wall1", new Vector2(0,-WALL_DISTANCE_FROM_CENTRE));
		walls[1] = new Wall("Wall2", new Vector2(0, WALL_DISTANCE_FROM_CENTRE));
		
		obstacles = new QueueLinkList();
		
		gameStateText = new Text("GameStateText", new Vector2() ,
				"Use Up Down Arrow Keys To Move. Press The Enter Key To Start!", GAME_STATE_FONT_SIZE, TextAlignment.CENTRE);
		
		scoreText = new Text("ScoreText", 
				new Vector2(-500, -(WALL_DISTANCE_FROM_CENTRE+SCORE_TEXT_DISTANCE_FROM_WALL)), 
				"Score: " + Integer.toString(score), SCORE_TEXT_FONT_SIZE, TextAlignment.LEFT);
	
		highScoreText = new Text("ScoreText", 
				new Vector2(500, -(WALL_DISTANCE_FROM_CENTRE+SCORE_TEXT_DISTANCE_FROM_WALL)), 
				"High Score: " + Integer.toString(highScore), SCORE_TEXT_FONT_SIZE, TextAlignment.RIGHT);
	}
	
	/********
	 * Gets high score from file, creates high score of 0 if file not found
	 * @return the high score of the game
	 */
	private int getHighScore() {
		Scanner inFile;
		try {
			inFile = new Scanner(new File("highscore.txt"));
			if(inFile.hasNext()) {
				return inFile.nextInt();
			}
			return 0;
		} catch (FileNotFoundException e) {
			setHighScore();
			return 0;
		}
	}
	
	/***********
	 * Sets the high score to be the current score, sets text to reflect new highscore
	 */
	private void setHighScore() {
		FileWriter fw;
		try {
			fw = new FileWriter("highscore.txt");
			PrintWriter output = new PrintWriter(fw);
			output.print(score);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		highScore = score;
		highScoreText.setText("High Score: " + Integer.toString(highScore));
		
	}
	
	/****
	 * Resets/Starts game: Creates new Player Vehicle, destroys text and old obstacles, resets score and game state
	 */
	private void startGame() {
		gameStateText.destroy();
		if(playerVehicle != null) {
			playerVehicle.destroy();
		}
		try {
			playerVehicle = new PlayerVehicle("Player", new Vector2(-400,0), new Vector2(200,100),this);
		} catch (IOException e) {
			System.out.println("Please put car.png properly.");
			e.printStackTrace();
		} // recreate playerVehicle
		
		while(!obstacles.isEmpty()) {
			obstacles.dequeue().destroy();
		}
		
		score = 0;
		
		isGameEnded = false;
		
		Obstacle.setMoving(true);
	}
	
	/*******
	 * Ends the game by freezing obstacles, displaying game state and updating high score
	 */
	public void endGame() {
		Obstacle.setMoving(false);

		gameStateText= new Text("GameStateText", new Vector2() ,"Press The Enter Key To Restart!", GAME_STATE_FONT_SIZE, TextAlignment.CENTRE);
		
		isGameEnded = true;
		
		if(score > highScore)
			setHighScore();
	}

	/********
	 * Takes Updates to Add to Score and Add/Remove Obstacles, also detects input to reset game
	 */
	@Override
	public void update() {
		if(!isGameEnded) {
			score+=10;
			scoreText.setText("Score: " + Integer.toString(score));
			Obstacle.setSpeed(10 + score/1000);
			if(score%OBSTACLE_DENSITY==0) {
				double obstacleLocation = Math.random()*(600-OBSTACLE_SIZE)-(600-OBSTACLE_SIZE)/2;
				try {
					obstacles.enqueue(new Obstacle("Obstacle", new Vector2(600, obstacleLocation), new Vector2(OBSTACLE_SIZE,OBSTACLE_SIZE)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!obstacles.isEmpty() && obstacles.peek().getX() < OBSTACLE_REMOVAL_X_COORD) {
				obstacles.dequeue().destroy();
			}
		}
		else if(Input.isEnterPressed())
			startGame();
		
	}
}
