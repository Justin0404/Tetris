import greenfoot.*; 

public class ITetromino extends Tetromino {
	ITetromino() {
		super("brown");
	}

	protected void addedToWorld(World world) {
		direction = 1;
		int start = 3;
		for (int i = 0; i < 4; i++) {
			getWorld().addObject(b[i], start + i, 2);
		}
		setDirection();
	}

	protected void setDirection() {
		switch (direction) {
		case NORTH:
		case SOUTH:
			for (int i = 0; i < 4; i++) {
				if (i == 1)
					continue;
				b[i].setLocation(b[1].getX(), b[1].getY() + 1 - i);
			}
			break;

		case WEST:
		case EAST:
			for (int i = 0; i < 4; i++) {
				if (i == 1)
					continue;
				b[i].setLocation(b[1].getX() - 1 + i, b[1].getY());
			}
			break;
		}
	}

	protected Block leftMost() {
		return b[0];
	}

	protected Block rightMost() {
		return b[3];
	}

	protected boolean turnPossible() {
		switch (direction) {
		case NORTH:
		case SOUTH:
			return b[0].getX() >= 1
					&& b[3].getX() <= TetrisWorld.getWorld().getWidth() - 3;
		default: // EAST, WEST
			return b[0].getY() < TetrisWorld.getWorld().getHeight() - 3;
		}
	}

	

}
