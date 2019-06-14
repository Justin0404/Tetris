import greenfoot.*; 
import java.util.Calendar;


public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 24.0f;
    
    private int score;

   
    public ScoreBoard(int score)
    {
        this.score = score;
    }
    
    protected void addedToWorld(World world) {
        makeImage("Game Over", "Lines: ", score);
    }

    
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
