import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


/**
 * Ground.java
 * 
 * This class has been provided for you.
 * 
 */
public class Ground {
	
	public static double y;
	private double[] x;
	private BufferedImage image;
	private Rectangle hitbox;
	private double speed;
	
	public Ground() {
		y = 400;
		x = new double[2];
		x[0] = 0;
		x[1] = 336;
		try {
			image = ImageIO.read(new File("Flappy-Ground.png"));
		} catch (Exception e) {
			System.err.println("Images not found in project directory!");
		}
		
		hitbox = new Rectangle(0,(int)y,275,100);
	}
	
	public void move(double dx) {
		x[0] -= dx;
		x[1] -= dx;
		
		if(x[0] < -336) {
			x[0] = x[1];
			x[1] = x[0] + 336;
		}
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, null, (int)x[0], (int)y);
		g.drawImage(image, null, (int)x[1], (int)y);
	}
	
	public boolean collides(Rectangle r) {
		return r.intersects(hitbox);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		Ground.y = y;
	}

	public double[] getX() {
		return x;
	}

	public void setX(double[] x) {
		this.x = x;
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	
}
