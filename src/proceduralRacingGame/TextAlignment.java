package proceduralRacingGame;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: TextAlignment - Final Project
 * Description: Gives alignment values for place to align
 */

public enum TextAlignment {
	LEFT(0), CENTRE(0.25), RIGHT(0.5); // values to align text to each position
	
	private double alignmentNeeded;
	
	private TextAlignment(double alignmentNeeded) {
		this.alignmentNeeded = alignmentNeeded;
	}
	
	public double getAlignmentNeeded() {
		return alignmentNeeded;
	}
}
