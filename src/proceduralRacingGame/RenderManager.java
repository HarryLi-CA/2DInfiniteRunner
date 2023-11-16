package proceduralRacingGame;

import java.util.*;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

/******************
 * @author Harry Li
 * Course: ICS4U - Computer Science
 * Date: June 22, 2022
 * Title: RenderManager - Final Project
 * Description: Renders all renderers
 */
public class RenderManager extends JPanel{
	private List<Renderer> renderers;
	
	public RenderManager() {
		setFocusable(true);
		renderers = new ArrayList<Renderer>();
	}
	
	/***
	 * Adds renderer to list
	 * @param renderer Renderer to add
	 */
	public void addRenderer(Renderer renderer) {
		renderers.add(renderer);
		sortRenderers(0, renderers.size()-1);
	}
	
	/**
	 * Removes renderer from list
	 * @param renderer Renderer to remove
	 */
	public void removeRenderer(Renderer renderer) {
		renderers.remove(renderer);
	}
	
	/***
	 * Swaps values
	 * @param index1 (Positive integer)
	 * @param index2 (Positive integer)
	 */
	private void swapVals(int index1, int index2) {
		Renderer temp = renderers.get(index1);
		renderers.set(index1, renderers.get(index2));
		renderers.set(index2, temp);
	}
	
	/**
	 * sorts renderers with quick sort
	 * @param startIndex The index to start (integer)
	 * @param endIndex The index to end(integer)
	 */
	private void sortRenderers(int startIndex, int endIndex) {
		if(startIndex >= endIndex)
			return; //ends recursion
		int k = startIndex; // variable to store lowest index with higher array value than the pivot
		int j = endIndex; // variable to store highest index with lower array value than the pivot
		int pivotIndex = (startIndex + endIndex) / 2; //middle index chosen as pivot
		while (k<j) {
			while(renderers.get(k).priority <renderers.get(pivotIndex).priority) {
				k++;
			}
			while(renderers.get(pivotIndex).priority < renderers.get(j).priority) {
				j--;
			}
			if(k<=j) {
				swapVals(k, j);
				k++;
				j--;
			}
			sortRenderers(startIndex,j);
			sortRenderers(k,endIndex);
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        Vector2 centreDraw = new Vector2(size.getWidth()/2,size.getHeight()/2);

    	PriorityQueue<Renderer> renderersCopy = new PriorityQueue<Renderer>(renderers);
        
        while(!renderersCopy.isEmpty()) {
        	renderersCopy.poll().render(g2d, centreDraw);
        }
    }
}
