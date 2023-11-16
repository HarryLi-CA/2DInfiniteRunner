package proceduralRacingGame;

import java.awt.event.KeyEvent;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: Input - Final Project
 * Description: receives input information, static due to only one keyboard can input
 */

public class Input {
	private static boolean upPressed = false; // if up arrow pressed
	private static boolean downPressed = false; // if down pressed
	private static boolean enterPressed = false; // if enter is pressed
	
	/***
	 * Checks which way a GameObject should move
	 * @return the direction gameobject should move, negative if up and positive if down
	 */
	public static int getMovementState() {
		if(!(upPressed^downPressed))
			return 0;
		if(upPressed)
			return -1;
		return 1;
	}
	
	/***
	 * Updates keys
	 * @param e The KeyEvent
	 * @param keyState The State of Key 
	 */
	public static void updateInput(KeyEvent e, KeyState keyState) {
		if(keyState == KeyState.PRESSED) {
			if(e.getKeyCode() == KeyEvent.VK_UP)
				upPressed = true;
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
				downPressed = true;
			else if(e.getKeyCode() == KeyEvent.VK_ENTER)
				enterPressed = true;
		}
		else if(keyState == KeyState.RELEASED) {
			if(e.getKeyCode() == KeyEvent.VK_UP)
				upPressed = false;
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
				downPressed = false;
			else if(e.getKeyCode() == KeyEvent.VK_ENTER)
				enterPressed = false;
		}
	}

	/**
	 * @return the enterPressed
	 */
	public static boolean isEnterPressed() {
		return enterPressed;
	}
}
