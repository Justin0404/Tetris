import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Represents a block of a tetromino
 * 
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 * 
 */
public class Block extends Actor {
	Block(String color) {
		setImage(color + "-block.png");
	}
}
