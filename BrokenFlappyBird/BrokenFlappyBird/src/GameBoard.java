import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * GameBoard.java
 * 
 * The GameBoard class contains the drawing methods needed to manage the game.
 * Many of the methods in this class will not be called by the programmer -
 * instead, they will be automatically called when something occurs. For
 * instance, mouseClicked is called when someone clicks on the game window.
 * 
 * You should not have to make any changes to this class for the assignment.
 * However, you might make changes to the mouse methods at the end of this class
 * to add extra features.
 * 
 * @author Jason Lawrence and Mark Sherriff
 * 
 */
public class GameBoard extends JPanel implements MouseListener {
	
	// **** YOU DO NOT NEED TO EDIT ANYTHING BELOW THIS LINE! ****//

	private static final long serialVersionUID = 1L;

	// width and height of the window
	private int width;
	private int height;

	// lastTime that the screen was refreshed
	private long lastTime;

	// a link back to the app
	private FlappyBird game;
	
	private JLabel counter;
	private int count;

	/**
	 * Constructor for the GameBoard
	 * 
	 * @param width_
	 *            width of the window
	 * @param height_
	 *            height of the window
	 * @param simulator_
	 *            link back to the game app
	 */
	public GameBoard(int width_, int height_, FlappyBird simulator_) {
		width = width_;
		height = height_;
		game = simulator_;
		lastTime = -1L;
		count = 0;
		
		counter = new JLabel("<html><h1>0</h1></html>");
		counter.setBounds(125, 450, 10, 10);
		this.add(counter);
		

	}
	
	public void addCounter(int numToAdd) {
		count = count + numToAdd;
		counter.setText("<html><h1>" + count + "</h1></html>");
	}

	/**
	 * Called to start the game
	 */
	public void setupAndDisplay() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.setSize(width, height);
		f.setLocation(200, 200);
		f.setVisible(true);
		
		this.addMouseListener(this);
		this.setFocusable(true);
	}

	/**
	 * This method is NEVER called by the programmer. This method is called
	 * whenever the screen refreshes. Consequently, it calls the draw() method
	 * in SurvivalField, telling it to update its components.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		boolean first = (lastTime == -1L);
		long elapsedTime = System.nanoTime() - lastTime;
		lastTime = System.nanoTime();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.white);
		game.draw((Graphics2D) g, (first ? 0.0f : (float) elapsedTime / 1e9f));
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		game.mouseAction(e.getX(), e.getY(), e.getButton());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
