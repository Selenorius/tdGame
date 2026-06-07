package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import render.Render;

public class GameScreen extends JPanel {

    // CONST DECLARATIONS
    final private Dimension size = new Dimension(640, 640);

    // VAR DECLARATIONS
    protected int fpsCounter,
            upsCounter;
    private final Game game;

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
    public Dimension getSize() {

        return size;

    }

    // FUNCTIONS - Java Swing
    public void paintComponent(final Graphics g) {

        super.paintComponent(g);

        game.getRender().render(g);

        showStats(g);

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

}
