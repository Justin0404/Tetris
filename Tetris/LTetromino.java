import greenfoot.*; 

public class LTetromino extends Tetromino {
	LTetromino() {
		super("orange");
	}

	protected void addedToWorld(World world) {
		direction = 4;
		int start = 4;
		getWorld().addObject(b[0], start + 2, 0);
		getWorld().addObject(b[1], start + 2, 1);
		getWorld().addObject(b[2], start + 1, 1);
		getWorld().addObject(b[3], start, 1);
		setDirection();
	}

	protected void setDirection() {
		switch (direction) {
		case NORTH:
			b[0].setLocation(b[2].getX() + 1, b[2].getY() + 1);
			b[1].setLocation(b[2].getX(), b[2].getY() + 1);
			b[3].setLocation(b[2].getX(), b[2].getY() - 1);
			break;
		case WEST:
			b[0].setLocation(b[2].getX() + 1, b[2].getY() - 1);
			b[1].setLocation(b[2].getX() + 1, b[2].getY());
			b[3].setLocation(b[2].getX() - 1, b[2].getY());
			break;
		case SOUTH:
			b[0].setLocation(b[2].getX() - 1, b[2].getY() - 1);
			b[1].setLocation(b[2].getX(), b[2].getY() - 1);
			b[3].setLocation(b[2].getX(), b[2].getY() + 1);
			break;
		case EAST:
			b[0].setLocation(b[2].getX() - 1, b[2].getY() + 1);
			b[1].setLocation(b[2].getX() - 1, b[2].getY());
			b[3].setLocation(b[2].getX() + 1, b[2].getY());
			break;
		}
	}

	protected Block leftMost() {
		switch (direction) {
		case NORTH:
			return b[2];
		case WEST:
			return b[3];
		case SOUTH:
			return b[0];
		default: // case EAST:
			return b[0];
		}
	}

	protected Block rightMost() {
		switch (direction) {
		case NORTH:
			return b[0];
		case WEST:
			return b[0];
		case SOUTH:
			return b[1];
		default: // case EAST:
			return b[3];
		}
	}

	protected boolean turnPossible() {
		TetrisWorld world = TetrisWorld.getWorld();
		switch (direction) {
		case NORTH:
			return b[2].getX() >= 1;
		case WEST:
			return b[2].getY() < world.getHeight() - 3;
		case SOUTH:
			return b[2].getX() < world.getWidth() - 1;
		default: // case EAST:
			return true;
		}
	}

	

}
