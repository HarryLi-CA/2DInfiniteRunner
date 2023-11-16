package proceduralRacingGame;
/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: Wall - Final Project
 * Description: creates prefabed wall
 */
public class Wall extends GameObject{

	Wall(String name, Vector2 coords) {
		super(name, coords, true, new LineCollisionDetector(coords), new LineRenderer(coords, 0, 1080));
	}

}
