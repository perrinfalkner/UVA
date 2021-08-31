import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Bird.java
 * 
 * This class represents the flappy bird in the game. Some code is provided for
 * you so you don't have to look it up. Further, we have provided some of the
 * values needed to position things properly.
 *
 */

public class Bird {

	// ***** FIELDS *****//

	/**
	 * The bird requires certain fields to make it work:
	 * 
	 * x and y coordinates (double)
	 * 
	 * y speed (double)
	 * 
	 * the effect of gravity on the bird (double)
	 * 
	 * an image (BufferedImage)
	 * 
	 * a hitbox (Rectangle)
	 * 
	 * Of these, the hitbox requires the most explanation. To determine if the
	 * bird is touching the ground or one of the pipes, we can use the Rectangle
	 * class that is built into Java. The Rectangle class has a method called
	 * intersects(Rectangle r). Thus, we can quickly determine if the bird is
	 * touching anything by writing a method that will take as a parameter a
	 * Rectangle and then we can use intersects() to see if the hitbox rectangle
	 * touching the rectangle passed in.
	 */

	private double x;
	private double y;
	private double dy;
	private double gravity;
	private BufferedImage image;
	private Rectangle hitbox;

	//***** METHODS *****//
	
	/**
	 * Constructor
	 * 
	 * In this constructor, set the starting position of the bird to (110,250).
	 * The y speed should be 0. Gravity is up to you to figure out. We have
	 * provided the code to lead the image and to create the hitbox.
	 */
	public Bird() {
		x = 110;
		y = 250;
		dy = 0;
		gravity = 2;
		try {
			image = ImageIO.read(new File("Flappy-Bird.png"));
		} catch (Exception e) {
			System.err.println("Images not found in project directory!");
		}

		hitbox = new Rectangle((int) x, (int) y, 25, 25);
	}

	/**
	 * This method draws the bird to the screen at it's current location.
	 */
	public void draw(Graphics2D g) {
		g.drawImage(image, null, (int) x, (int) y);
	}

	/**
	 * This method should apply gravity, move the bird according to it's y speed, and update the location of the hitbox to match the image's location.
	 */
	public void move(float elapsedTime) {
		dy = dy + gravity;
		y = y + dy * elapsedTime;
		hitbox.setLocation((int) x, (int) y);
	}

	/**
	 * This method should make the bird flap.  What does it mean to flap in this game?
	 */
	public void flap() {
		dy = -200;
	}

	/**
	 * This method handles the hitbox collision detection.
	 */
	public boolean collides(Rectangle r) {
		return r.intersects(hitbox);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}

}
