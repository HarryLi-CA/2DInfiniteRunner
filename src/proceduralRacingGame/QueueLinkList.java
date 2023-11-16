package proceduralRacingGame;


/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: QueueLinkList - Final Project
 * Description: Queue using linked list
 */

public class QueueLinkList{

	protected Link first;
	protected Link last;
	
	public QueueLinkList() {
		
	}
	public QueueLinkList(Obstacle obstacle) {
		first = new Link(obstacle);
	}
	
	/***
	 * Add to queue
	 * @param obstacle Obstacle to add
	 */
	public void enqueue(Obstacle obstacle) {
		if(first == null) {
			first = new Link(obstacle);
			return;
		}
		
		Link currentLink = first;
		while(currentLink.next != null ) {
			currentLink = currentLink.next;
		}
		currentLink.next = new Link(obstacle);
		last = currentLink.next;
	}
	
	/***
	 * Return first value
	 * @return Obstacle on top
	 */
	public Obstacle peek() {
		return first.obstacle;
	}
	
	/**
	 * Removes first value
	 * @return first Obstacle
	 */
	public Obstacle dequeue() {
		Link returnLink = first;
		if(first.next == null)
			first = null;
		else
			first = first.next;
		return returnLink.obstacle;
	}
	
	/***
	 * Check if empty
	 * @return If it is empty(bool)
	 */
	public boolean isEmpty() {
		return first==null;
	}
}
