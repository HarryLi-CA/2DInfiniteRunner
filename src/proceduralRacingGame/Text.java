package proceduralRacingGame;


/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: Text - Final Project
 * Description: Text Object To Add Text To screen
 */

public class Text extends GameObject{

	Text(String name, Vector2 coords, String text, int fontSize, TextAlignment alignment) {
		super(name, coords, true, null, new TextRenderer(coords, 100, text, fontSize, alignment));
	}
	
	/***
	 * Sets up text
	 * @param text Text to set(string)
	 */
	public void setText(String text) {
		((TextRenderer)getRenderer()).setText(text);
	}
}
