import greenfoot.*; 

public class STetromino extends Tetromino {
	STetromino() {
		super("green");
	}

	protected void addedToWorld(World world) {
		direction = 2;
		int start = 4;
		getWorld().addObject(b[0], start, 1);
		getWorld().addObject(b[1], start + 1, 1);
		getWorld().addObject(b[2], start + 1, 0);
		getWorld().addObject(b[3], start + 2, 0);
		setDirection();
	}

	protected void setDirection() {
		switch (direction) {//Changes the block based on the direction
		case NORTH:
		case SOUTH:
			b[0].setLocation(b[1].getX() - 1, b[1].getY());
			b[2].setLocation(b[1].getX(), b[1].getY() - 1);
			b[3].setLocation(b[1].getX() + 1, b[1].getY() - 1);
			break;
		case WEST:
		case EAST:
			b[0].setLocation(b[1].getX(), b[1].getY() + 1);
			b[2].setLocation(b[1].getX() - 1, b[1].getY());
			b[3].setLocation(b[1].getX() - 1, b[1].getY() - 1);
			break;
		}
	}

	protected Block leftMost() {
		switch (direction) {
		case NORTH:
		case SOUTH:
			return b[0];
		default: // WEST, EAST
			return b[2];
		}
	}

	protected Block rightMost() {
		switch (direction) {
		case NORTH:
		case SOUTH:
			return b[3];
		default: // WEST, EAST
			return b[1];
		}
	}

	protected boolean turnPossible() {
		TetrisWorld world = TetrisWorld.getWorld();
		switch (direction) {
		case NORTH:
		case SOUTH:
			return b[0].getY() < world.getHeight() - 3;
		default: // WEST, EAST
			return b[1].getX() < world.getWidth() - 1;
		}
	}

	

}
