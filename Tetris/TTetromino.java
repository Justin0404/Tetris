import greenfoot.*; 

public class TTetromino extends Tetromino {
	TTetromino() {
		super("magenta");
	}

	protected void addedToWorld(World world) {
		direction = 4;
		int start = 4;
		getWorld().addObject(b[0], start + 1, 0);
		getWorld().addObject(b[1], start, 1);
		getWorld().addObject(b[2], start + 1, 1);
		getWorld().addObject(b[3], start + 2, 1);
		setDirection();
	}

	protected void setDirection() {//Changes the block based on the direction
		switch (direction) {
		case NORTH:
			b[0].setLocation(b[2].getX(), b[2].getY() - 1);
			b[1].setLocation(b[2].getX() - 1, b[2].getY());
			b[3].setLocation(b[2].getX() + 1, b[2].getY());
			break;
		case WEST:
			b[0].setLocation(b[2].getX() - 1, b[2].getY());
			b[1].setLocation(b[2].getX(), b[2].getY() + 1);
			b[3].setLocation(b[2].getX(), b[2].getY() - 1);
			break;
		case SOUTH:
			b[0].setLocation(b[2].getX(), b[2].getY() + 1);
			b[1].setLocation(b[2].getX() + 1, b[2].getY());
			b[3].setLocation(b[2].getX() - 1, b[2].getY());
			break;
		case EAST:
			b[0].setLocation(b[2].getX() + 1, b[2].getY());
			b[1].setLocation(b[2].getX(), b[2].getY() - 1);
			b[3].setLocation(b[2].getX(), b[2].getY() + 1);
			break;
		}
	}

	protected Block leftMost() {
		switch (direction) {
		case NORTH:
			return b[1];
		case WEST:
			return b[0];
		case SOUTH:
			return b[3];
		default: // case EAST:
			return b[2];
		}
	}

	protected Block rightMost() {
		switch (direction) {
		case NORTH:
			return b[3];
		case WEST:
			return b[2];
		case SOUTH:
			return b[1];
		default: // case EAST:
			return b[0];
		}
	}

	protected boolean turnPossible() {
		TetrisWorld world = TetrisWorld.getWorld();
		switch (direction) {
		case NORTH:
			return b[2].getY() < world.getHeight() - 3;
		case WEST:
			return b[2].getX() < world.getWidth() - 1;
		case SOUTH:
			return true;
		default: // case EAST:
			return b[2].getX() >= 1;
		}
	}

	

}
