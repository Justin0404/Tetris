import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling (modified by Dietrich Boles)
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 24.0f;
    
    private int score;

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {
        this.score = score;
    }
    
    protected void addedToWorld(World world) {
        makeImage("Game Over", "Score: ", score);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        int WIDTH = (getWorld().getWidth()+2) * getWorld().getCellSize();
        int HEIGHT = WIDTH;
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, WIDTH / 6, HEIGHT / 3);
        image.drawString(prefix + score, WIDTH / 6, 2 * HEIGHT / 3);
        setImage(image);
    }
}
