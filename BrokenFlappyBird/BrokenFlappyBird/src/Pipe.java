import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * Pipe.java
 * 
 * This class represents both the top and bottom portions of a pipe.
 *
 */
public class Pipe {

	// ***** FIELDS *****//
	private double x;
	private double y;
	private double space;
	private Rectangle topHitbox;
	private Rectangle bottomHitbox;
	private BufferedImage topImage;
	private BufferedImage bottomImage;

	// ***** METHODS *****//

	/**
	 * Constructor
	 * 
	 * When you create a new pipe, the location of the opening should be
	 * randomly generated. Set the x location off the screen to the right
	 * (>250). It is up to you to determine how to create the top and bottom
	 * parts of the pipe. Consider that 100 would be a reasonable size space in
	 * between the bottom of the top pipe and top of the bottom pipe. Further,
	 * note that 0 is the top of the screen's y coordinate. The pipe's image
	 * itself is 75 pixels wide and 431 pixels tall. It is okay (and expected)
	 * for the pipe's image to "hang off" the top and bottom of the screen. Make
	 * sure to allocate the hitboxes for the pipes as well!
	 */
	public Pipe() {
		Random rand = new Random();
		x = 300;
		y = rand.nextInt(200) + 50;
		space = 100;
		try {
			topImage = ImageIO.read(new File("Flappy-Pipe-Top.png"));
		} catch (Exception e) {
			System.err.println("Images not found in project directory!");
		}
		try {
			bottomImage = ImageIO.read(new File("Flappy-Pipe-Bottom.png"));
		} catch (Exception e) {
			System.err.println("Images not found in project directory!");
		}
		// I wonder if this line works?...
		//topHitbox = new Rectangle((int) x, (int) y - 431, 75, 431);
		bottomHitbox = new Rectangle((int) x, (int) y + (int) space, 75, 431);

	}

	/**
	 * Fill in this method to draw the two pipe images.  Reference code from other files to see how to call g.drawImage().
	 */
	public void draw(Graphics2D g) {
		g.drawImage(topImage, null, (int) x, (int) y - 431);
		g.drawImage(bottomImage, null, (int) x, (int) y + (int) space);
	}

	/**
	 * Fill in this method to move the pipes from right to left.  Meke sure to reset the hitboxes when the images move.
	 */
	public void move(double dx) {
		x = x - dx;
		topHitbox.setLocation((int) x, (int) y - 431);
		bottomHitbox.setLocation((int) x, (int) y + (int) space);
	}


	/**
	 * This method should return true if either hitbox intersects the bird's hitbox.
	 */
	public boolean collides(Bird b) {
		return b.collides(topHitbox);
	}

	@Override
	public String toString() {
		return "Pipe [x=" + x + ", y=" + y + ", space=" + space + ", topHitbox=" + topHitbox
				+ ", bottomHitbox=" + bottomHitbox + "]";
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

	public double getSpace() {
		return space;
	}

	public void setSpace(double space) {
		this.space = space;
	}

	public Rectangle getTopHitbox() {
		return topHitbox;
	}

	public void setTopHitbox(Rectangle topHitbox) {
		this.topHitbox = topHitbox;
	}

	public Rectangle getBottomHitbox() {
		return bottomHitbox;
	}

	public void setBottomHitbox(Rectangle bottomHitbox) {
		this.bottomHitbox = bottomHitbox;
	}

	public BufferedImage getTopImage() {
		return topImage;
	}

	public void setTopImage(BufferedImage topImage) {
		this.topImage = topImage;
	}

	public BufferedImage getBottomImage() {
		return bottomImage;
	}

	public void setBottomImage(BufferedImage bottomImage) {
		this.bottomImage = bottomImage;
	}

}
