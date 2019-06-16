import greenfoot.*; 

public class OTetromino extends Tetromino {
	OTetromino() {
		super("yellow");
	}

	protected void addedToWorld(World world) {
		direction = NORTH;
		int start = 4;
		getWorld().addObject(b[0], start, 0);
		getWorld().addObject(b[1], start + 1, 0);
		getWorld().addObject(b[2], start, 1);
		getWorld().addObject(b[3], start + 1, 1);
	}

	protected void setDirection() {//Doens't need to change based on direction
	}

	protected boolean turnPossible() {
		return false;
	}

	protected Block leftMost() {
		return b[0];
	}

	protected Block rightMost() {
		return b[1];
	}

	
}