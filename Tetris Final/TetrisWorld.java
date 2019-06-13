import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The world of tetris
 * 
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (15.02.2007)
 * 
 */
public class TetrisWorld extends World {

	private static TetrisWorld world = null;

	private Points pointView;

	private Tetromino currentTetromino;
	
	private int numberOfTetrominos;
	
	private int speed;

	/**
	 * Creates a tetris world with 10 columns and 22 rows
	 */
	public TetrisWorld() {
		this(10, 24);
	}

	/**
	 * Creates a tetris world with "cols" columns and "rows" rows
	 * 
	 * @param cols
	 *            number of columns (>= 9)
	 * @param rows
	 *            number of rows (>= 10)
	 */
	public TetrisWorld(int cols, int rows) {
		super(cols < 9 ? 9 : cols, (rows < 10 ? 10 : rows) + 2, 20);

		world = this;

		setBackground("cell.png");

		for (int i = 0; i < cols; i++) {
			addObject(new Wall(), i, rows);
		}

		this.pointView = new Points();

		this.speed = 30;
		Greenfoot.setSpeed(this.speed);
		this.numberOfTetrominos = 0;
		currentTetromino = genTetromino();
	}

	// returns the current world
	static TetrisWorld getWorld() {
		return world;
	}

	// returns the current tetromino or null if game terminated
	Tetromino getCurrentTetromino() {
		return currentTetromino;
	}

	// changes the current tetromino
	void setCurrentTetromino(Tetromino t) {
		currentTetromino = t;
	}

	// creates randomly a new tetromino
	Tetromino genTetromino() {
	    this.numberOfTetrominos +=1;
		
		int rand = (int) (Math.random() * 7);
		switch (rand) {
		case 0:
			return new ITetromino();
		case 1:
			return new JTetromino();
		case 2:
			return new LTetromino();
		case 3:
			return new OTetromino();
		case 4:
			return new TTetromino();
		case 5:
			return new STetromino();
		default: // 6
			return new ZTetromino();
		}
	}

	// adds new points to the point view
	void newPoints(int rows) {
		int p = 0;
		switch (rows) {
		case 1:
			p = 40;
			break;
		case 2:
			p = 100;
			break;
		case 3:
			p = 300;
			break;
		case 4:
			p = 1200;
			break;
		}
		pointView.add(p);
	}

	// returns the current points of the player
	int getPoints() {
		return pointView.getPoints();
	}
	
	// game over
	void gameOver() {
	    addObject(new ScoreBoard(getPoints()), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
   }

}
