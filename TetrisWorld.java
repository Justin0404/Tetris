import greenfoot.*; 
import java.awt.Color;

public class TetrisWorld extends World {

    private static TetrisWorld world = null;

    private Points pointView;

    private Tetromino currentTetromino;
    
    private int numberOfTetrominos;
    
    private int speed;

    
    public TetrisWorld() {
        this(10, 24);
    }

    
    public TetrisWorld(int cols, int rows) {
        super(cols < 9 ? 9 : cols, (rows < 10 ? 10 : rows) + 2, 20);

        world = this;

        setBackground("cell.png");

        for (int i = 0; i < cols; i++) {
            Wall temp = new Wall();
            
            addObject(temp, i, rows);
            
        }
        for(int i = 0; i < 10; i++){
           this.getBackground().drawLine(20*i,0,20*i,480);
        }
        for(int j = 0; j < 24; j++){
            this.getBackground().drawLine(0,20*j,200,20*j);
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
            p = 1;
            break;
        case 2:
            p = 2;
            break;
        case 3:
            p = 3;
            break;
        case 4:
            p = 4;
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
