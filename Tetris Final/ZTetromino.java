import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * represents a Z tetromino
 * 
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 * 
 */
public class ZTetromino extends Tetromino {
	ZTetromino() {
		super("red");
	}

	protected void addedToWorld(World world) {
		direction = genDirection();
		int start = genStartX();
		getWorld().addObject(b[0], start, 1);
		getWorld().addObject(b[1], start + 1, 1);
		getWorld().addObject(b[2], start + 1, 2);
		getWorld().addObject(b[3], start + 2, 2);
		setDirection();
	}

	protected void setDirection() {
		switch (direction) {
		case NORTH:
		case SOUTH:
			b[0].setLocation(b[1].getX() - 1, b[1].getY());
			b[2].setLocation(b[1].getX(), b[1].getY() + 1);
			b[3].setLocation(b[1].getX() + 1, b[1].getY() + 1);
			break;
		case WEST:
		case EAST:
			b[0].setLocation(b[1].getX(), b[1].getY() - 1);
			b[2].setLocation(b[1].getX() - 1, b[1].getY());
			b[3].setLocation(b[1].getX() - 1, b[1].getY() + 1);
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
			return b[2].getY() < world.getHeight() - 3;
		default: // WEST, EAST
			return b[1].getX() < world.getWidth() - 1;
		}
	}

	protected int genStartX() {
		return (int) (Math.random() * (TetrisWorld.getWorld().getWidth() - 2));
	}

}
