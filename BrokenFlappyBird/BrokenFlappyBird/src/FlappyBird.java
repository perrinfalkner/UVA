import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class FlappyBird {
	
	public static final int SCREEN_WIDTH = 275;
	public static final int SCREEN_HEIGHT = 500;

	// The game needs a board to draw on. The GameBoard board is the window that
	// we'll use.
	private GameBoard board;
	
	// Used to keep up with how often to create new pipes
	private int ticks = 0;
	
	// Whether the game is over or not
	private boolean gameover;
	
	// Image for the background
	private BufferedImage backgroundImage;
	
	// The ground
	private Ground ground;
	
	// The flappy bird
	private Bird bird;
	
	// All of the pipes
	private ArrayList<Pipe> pipes;
	
	/**
	 * This is the main drawing function that is automatically called whenever
	 * the canvas is ready to be redrawn. The 'elapsedTime' argument is the
	 * time, in seconds, since the last time this function was called.
	 * 
	 * In this method, you need to:
	 * 
	 * Draw all the objects
	 * 
	 * Move all the objects that need moving
	 * 
	 * Check for collisions with the bird with the ground and all the pipes
	 * 
	 * Increase the counter for passing a pipe
	 * 
	 * Create new pipes at a regular interval using ticks
	 */
	public void draw(Graphics2D g, float elapsedTime) {
		
		ticks++
		
		if(gameover) {
			
			drawBackground(g);
			drawPipes(g);
			ground.draw(g);
			bird.draw(g);
			return;
		}
		
		if(ticks % 15000 == 0) {
			Pipe pipe = new Pipe();
			pipes.add(pipe);
		}
		
		drawBackground(g);
		
		movePipes(elapsedTime);
		drawPipes(g);
		
		ground.move(100*elapsedTime);
		ground.draw(g);
		
		bird.move(elapsedTime);
		bird.draw(g);
		
		if(bird.collides(ground.getHitbox())) {
			gameover = true;
		}
		for(int i = 0; i < pipes.size(); i++) {
			Pipe p = pipes.get(i);
			if(p.getX() < -75) {
				pipes.remove(i);
				i--;
				board.addCounter(1);
			}
			else if(p.collides(bird)) {
				gameover = true;
			}

		}
		
	}
	
	/**
	 * Fill in this method to draw all the pipes on the screen
	 */
	public void drawPipes(Graphics2D g) {
		for(Pipe p : pipes) {
			p.draw(g);
		}
	}
	
	/**
	 * Fill in this method to move all the pipes, using elapsedTime as a modifier
	 */
	public void movePipes(float elapsedTime) {
		for(Pipe p : pipes) {
			p.move(100*elapsedTime);
		}
		
	}
	
	
	/**
	 * Use this method to handle all mouse input.  The main action here is to have 
	 * the bird flap whenever the mouse is clicked.
	 */
	public void mouseAction(int x, int y, int button) {

		if (button == 1) {
			System.out.println("You clicked here!");
		}

	}
	
	/**
	 * The Constructor - This method should instantiate a new canvas and place
	 * the first targets.
	 */
	public FlappyBird() {

		// Create canvas object with x by y spatial dimensions.
		board = new GameBoard(SCREEN_WIDTH, SCREEN_HEIGHT, this);
		
		// Load the background image
		try {
			backgroundImage = ImageIO.read(new File("Flappy-Background.png"));
		} catch (Exception e) {
			System.err.println("Images not found in project directory!");
		}
		
		// initialize all the game objects
		ground = new Ground();
		bird = new Bird();
		
		
		// set the game to not over yet
		gameover = false;

	}
	
	public void drawBackground(Graphics2D g) {
		g.drawImage(backgroundImage, null, 0, 0);
		
	}

	/**
	 * Your standard main method. Nothing for you to change here.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		FlappyBird game = new FlappyBird();
		game.play();
	}

	/**
	 * This method starts the game. Nothing for you to change here.
	 */
	public void play() {
		board.setupAndDisplay();
	}
}
