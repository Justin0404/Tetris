import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * abstract super class of all tetrominos; contains the act-method
 * 
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 * 
 */
public abstract class Tetromino extends Actor {

	// possible directions of a tetromino
	protected static final int NORTH = 0;

	protected static final int WEST = 1;

	protected static final int SOUTH = 2;

	protected static final int EAST = 3;

	protected Block[] b; // each tetromino consists of four blocks

	int direction; // direction of the tetromino

	boolean dead; // is the tetromino dead?

	private int counter; // internal counter

	Tetromino(String color) {
		setImage("cell.png");
		b = new Block[4];
		for (int i = 0; i < 4; i++) {
			b[i] = new Block(color);
		}
		counter = 0;
		dead = false;
		TetrisWorld.getWorld().addObject(this, 0,
				TetrisWorld.getWorld().getHeight() - 1);
	}

	// changes the direction of a tetromino; the current direction is stored in
	// attribute direction
	abstract protected void setDirection();

	// left most block of the tetromino (depending on its direction)
	abstract protected Block leftMost();

	// right most block of the tetromino (depending on its direction)
	abstract protected Block rightMost();

	// is left turn possible?
	abstract protected boolean turnPossible();

	// deletes the four blocks of a tetromino
	void delete() {
		for (int i = 0; i < 4; i++) {
			getWorld().removeObject(b[i]);
		}
		dead = true;
	}

	// the current tetromino (more precisely its blocks) are falling down
	public void act() {
		TetrisWorld world = TetrisWorld.getWorld();
		if (world.getCurrentTetromino() == null) { // game ended
		    world.gameOver();
			return;
		}

	    if (dead)
			return;
			
		// checking user interactions
		boolean keyAction = false;
		if (Greenfoot.isKeyDown("left") && counter < 4) {
			if (left()) {
				counter++;
				keyAction = true;
			}
		}
		if (Greenfoot.isKeyDown("right") && counter < 4) {
			if (right()) {
				counter++;
				keyAction = true;
			}
		}
		if (Greenfoot.isKeyDown("up") && counter < 3) {
			if (turnLeft()) {
				counter++;
				keyAction = true;
			}
		}
		if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown(" ")) {
			down();
			return;
		}

		if (keyAction) {
			return;
		}

		// one row down
		oneDown();
		counter = 0;
	}

	// one column to the left
	boolean left() {
		if (leftOccupied())
			return false;
		for (int i = 0; i < 4; i++) {
			b[i].setLocation(b[i].getX() - 1, b[i].getY());
		}
		return true;
	}

	// left shift possible?
	boolean leftOccupied() {
		if (leftMost().getX() == 0) {
			return true;
		}
		TetrisWorld world = TetrisWorld.getWorld();
		blocks: for (int i = 0; i < 4; i++) {
			java.util.List list = world.getObjectsAt(b[i].getX() - 1, b[i]
					.getY(), Block.class);
			if (list.size() == 0) {
				continue;
			}
			// then list.size() == 1
			Actor a = (Actor) list.get(0);
			for (int j = 0; j < 4; j++) {
				if (i == j)
					continue;
				if (a == b[j])
					continue blocks;
			}
			return true;
		}
		return false;
	}

	// one column to the right
	boolean right() {
		if (rightOccupied())
			return false;
		for (int i = 0; i < 4; i++) {
			b[i].setLocation(b[i].getX() + 1, b[i].getY());
		}
		return true;
	}

	// right shif possible?
	boolean rightOccupied() {
		if (rightMost().getX() == TetrisWorld.getWorld().getWidth() - 1) {
			return true;
		}
		TetrisWorld world = TetrisWorld.getWorld();
		blocks: for (int i = 0; i < 4; i++) {
			java.util.List list = world.getObjectsAt(b[i].getX() + 1, b[i]
					.getY(), Block.class);
			if (list.size() == 0) {
				continue;
			}
			// then list.size() == 1
			Actor a = (Actor) list.get(0);
			for (int j = 0; j < 4; j++) {
				if (i == j)
					continue;
				if (a == b[j])
					continue blocks;
			}
			return true;
		}
		return false;
	}

	// change the direction of the tetromino
	boolean turnLeft() {
		if (!turnPossible()) {
			return false;
		}
		int oldDir = direction;
		direction = (direction + 1) % 4;
		setDirection();
		TetrisWorld world = TetrisWorld.getWorld();
		for (int i = 0; i < 4; i++) {
			java.util.List list = world.getObjectsAt(b[i].getX(), b[i].getY(),
					null);
			if (list.size() > 1) {
				direction = oldDir;
				setDirection();
				return false;
			}
		}
		return true;
	}

	// tetromino slides one row down
	boolean oneDown() {
		// checks whether the tetromino is on the bottom row
		for (int i = 0; i < 4; i++) {
			if (!blockFree(i)) {
				checkRows();
				die();
				return false;
			}
		}

		// falling down
		for (int i = 0; i < 4; i++) {
			b[i].setLocation(b[i].getX(), b[i].getY() + 1);
		}
		return true;
	}

	// the tetromino is sliding to the bottom row
	void down() {
		while (oneDown())
			;
	}

	// is the cell below the block free?
	boolean blockFree(int index) {
		TetrisWorld world = TetrisWorld.getWorld();
		java.util.List list = world.getObjectsAt(b[index].getX(), b[index]
				.getY() + 1, null);
		if (list.size() == 0) {
			return true;
		}
		// then list.size() == 1
		Actor a = (Actor) list.get(0);
		for (int i = 0; i < 4; i++) {
			if (i == index)
				continue;
			if (a == b[i])
				return true;
		}
		return false;
	}

	// checks whether there exists completed rows which can be removed
	void checkRows() {
		int noOfRows = 0;
		TetrisWorld world = TetrisWorld.getWorld();
		rows: for (int r = world.getHeight() - 3; r >= 0; r--) {
			cols: for (int c = 0; c < world.getWidth(); c++) {
				java.util.List blocks = world.getObjectsAt(c, r, Block.class);
				if (blocks.size() == 0) {
					continue rows; // next row
				}
			}
			// clear row
			clearRow(r);
			noOfRows++;
			landslide(r);
			r++;
		}
		if (noOfRows > 0) {
			world.newPoints(noOfRows);
		}
	}

	// removes the blocks of a row
	void clearRow(int row) {
		TetrisWorld world = TetrisWorld.getWorld();
		for (int c = 0; c < world.getWidth(); c++) {
			world.removeObjects(world.getObjectsAt(c, row, Block.class));
		}
	}

	// performs a "landslide"
	void landslide(int row) {
		TetrisWorld world = TetrisWorld.getWorld();
		for (int r = row - 1; r >= 0; r--) {
			for (int c = 0; c < world.getWidth(); c++) {
				java.util.List blocks = world.getObjectsAt(c, r, Block.class);
				if (blocks.size() > 0) {
					Block block = (Block) blocks.get(0);
					block.setLocation(block.getX(), block.getY() + 1);
				}
			}
		}
	}

	// kills the tetromino
	void die() {
		TetrisWorld world = TetrisWorld.getWorld();
		world.removeObject(this);
		dead = true;
		Tetromino tetro = world.genTetromino();
		if (checkEnd(tetro)) {
			tetro.delete();
			world.setCurrentTetromino(null);
			world.gameOver();
		} else {
			TetrisWorld.getWorld().setCurrentTetromino(tetro);
		}
	}

	// checks whether the game has completed
	boolean checkEnd(Tetromino tetro) {
		TetrisWorld world = TetrisWorld.getWorld();
		for (int i = 0; i < 4; i++) {
			java.util.List list = world.getObjectsAt(tetro.b[i].getX(),
					tetro.b[i].getY(), Block.class);
			if (list.size() > 1) {
				return true;
			}
		}
		return false;
	}

	// generates a direction randomly
	int genDirection() {
		return (int) (Math.random() * 4);
	}

	// return the number of digits of a number
	int length(int number) {
		if (number < 10)
			return 1;
		return length(number / 10) + 1;
	}
}
