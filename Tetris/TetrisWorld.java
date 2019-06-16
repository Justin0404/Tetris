import greenfoot.*; 
import java.awt.Color;

public class TetrisWorld extends World {

    private static TetrisWorld world = null;
    private Points pointView;
    private Tetromino currentTetromino;
    private int numberOfTetrominos;   
    private int speed;
    
    public TetrisWorld() {
        this(10, 24); //Creates a grid 24 by 10
    }

    
    public TetrisWorld(int cols, int rows) {
        super(cols, rows + 2, 20);
        //Needs the extra 2 tested by hardcode, 20 is size of block/cell
        world = this;        
        setBackground("cell.png");

        for (int i = 0; i < cols; i++) {
            Wall temp = new Wall();            
            addObject(temp, i, rows);
            //adds each column of blocks
        }
        for(int i = 0; i < 10; i++){ //DrawLine(x0,y0,x1,y1)
           this.getBackground().drawLine(20*i,0,20*i,480);//Draws line through column with a length of 480
        }
        for(int j = 0; j < 24; j++){
            this.getBackground().drawLine(0,20*j,200,20*j);//Draws line through row with length of 200
        }
        this.pointView = new Points();
        this.speed = 30;
        Greenfoot.setSpeed(this.speed);//Sets speed of game to control dropping
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
        switch (rand) { //Switch case: similar to if else statement
        case 0: //if 0
            return new ITetromino();
        case 1: // if 1
            return new JTetromino();
        case 2: //if 2
            return new LTetromino();
        case 3: // if 3
            return new OTetromino();
        case 4: // if 4
            return new TTetromino();
        case 5: //if 5
            return new STetromino();
        default: // if 6
            return new ZTetromino();
        }
    }
    // adds new points to the point view
    void newPoints(int rows) {
        int p = 0;
        switch (rows) {//Switch Case again input of how many rows are cleared
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
