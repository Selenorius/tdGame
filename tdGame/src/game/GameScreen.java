package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import helpers.LevelBuild;
import inputs.KeyboardTracker;
import inputs.MouseTracker;

public class GameScreen extends JPanel {

    // CONST DECLARATIONS
    public static final Dimension size = new Dimension(640, 640);
    public static final Font UIFont = new Font("Georgia", Font.PLAIN, 16);

    // VAR DECLARATIONS
    protected int fpsCounter,
            upsCounter,
            clicked,
            clickedX,
            clickedY;
    private final Game game;
    protected MouseTracker mouse;
    private KeyboardTracker keyboard;

    // CONSTRUCTORS
    public GameScreen(final Game game) {

        // VAR INITIALIZATIONS
        this.game = game;

        // JFrame
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    // GETTERS
    public void setClicked(int clicked) {

        this.clicked = clicked;

    }

    // FUNCTIONS - INITIALIZERS
    protected void initInputs() {

        mouse = new MouseTracker(game);
        keyboard = new KeyboardTracker();

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(keyboard);

        requestFocus();

    }

    // FUNCTIONS - Java Swing
    public void paintComponent(final Graphics g) {

        super.paintComponent(g);

        game.getRender().render(g);

        showStats(g);
        renderMouseRelease(g);

    }

    // FUNCTIONS
    private void showFPS(final Graphics g) {

        final Color statsBackground = new Color(0, 0, 0, 125);

        g.setColor(statsBackground);
        g.fillRect(0, 0, 57, 10);

        g.setColor(Color.GREEN);
        g.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        g.drawString("FPS: " + fpsCounter, 0, 9);

    }

    private void showUPS(final Graphics g) {

        final Color statsBackground = new Color(0, 0, 0, 125);

        g.setColor(statsBackground);
        g.fillRect(0, 0, 50, 10);

        g.setColor(Color.BLUE);
        g.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        g.drawString("UPS: " + upsCounter, 0, 9);

    }

    private void showStats(final Graphics g) {

        final Color statsBackground = new Color(0, 0, 0, 125);

        g.setColor(statsBackground);
        g.fillRect(0, 0, 114, 10);

        g.setColor(Color.GREEN);
        g.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        g.drawString("FPS: " + fpsCounter, 0, 9);

        g.setColor(Color.BLUE);
        g.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        g.drawString("UPS: " + upsCounter, 64, 9);

    }

    public void renderMouseRelease(final Graphics g) {

		if (clicked > 0) {
			
			g.setColor(new Color(255, 255, 255, 35));
			g.fillArc(

				clickedX - LevelBuild.tileSize / (clicked * 4),
				clickedY - LevelBuild.tileSize / (clicked * 4),
				LevelBuild.tileSize / (clicked * 2),
				LevelBuild.tileSize / (clicked * 2),
				0,
				360

			);
		
		}

	}

    public void decrementClicked() {

		if (clicked >= 1) {

			--clicked;

		} else {

			clicked = 0;

		}

	}

    public void mouseClicked(int x, int y) {

        clicked = 8;
        clickedX = x;
        clickedY = y;

    }

    public static final void drawText(String text, int x, int y, Graphics g) {

        g.drawString(
            
            text,
            x - g.getFontMetrics().stringWidth(text) / 2,
            y + g.getFontMetrics().getHeight() * 4 / 11
        
        );

    }

}
