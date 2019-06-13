/**
 * Represents the view of attained points
 * 
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 * 
 */
public class Points {

	private int points;
	Counter counter;

	Points() {
		TetrisWorld world = TetrisWorld.getWorld();
		counter = new Counter("");
		world.addObject(counter, world.getWidth() / 2, world.getHeight()-1);
	}

	void add(int points) {
		counter.add(points);
	}
	
	int getPoints() {
	    return counter.getValue();
	}

}
