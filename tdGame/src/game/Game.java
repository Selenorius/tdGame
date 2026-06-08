package game;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import helpers.LoadSave;
import inputs.KeyboardTracker;
import inputs.MouseTracker;
import render.Render;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

public class Game extends JFrame implements Runnable {

    // VAR DECLARATIONS
    private BufferedImage icon;
    private long lastUpdate,
            lastFrame,
            lastUpdateTime,
            lastFrameTime;
    private int updates,
            frames;
    private Thread gameThread;
    private MouseTracker mouse;
    private KeyboardTracker keyboard;

    //CLASSES
    private GameScreen gameScreen;
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    // CONST DECLARATIONS
    final private String title = "Tower Defense Game";
    final private int FPS = 999,
            UPS = 60;
    final private double timePerFrame = 1000000000.0 / FPS,
            timePerUpdate = 1000000000.0 / UPS;

    // CONSTRUCTORS
    public Game() {

        // VAR INITIALIZATIONS
        updates = 0;
        frames = 0;

        // BufferedImage
        icon = LoadSave.loadImg("res/tdIcon.png");

        // Classes
        initClasses();

        // JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(title);
        setIconImage(icon);
        setResizable(false);
        add(gameScreen);
        pack();
        setLocationRelativeTo(null);
        setVisible(rootPaneCheckingEnabled);

    }

    // GETTERS
    public Dimension getSize() {

        return gameScreen.getSize();

    }

    public Render getRender() {

        return render;

    }

    public Menu getMenu() {
        
        return menu;

    }

    public Playing getPlaying() {

        return playing;

    }

    public Settings getSettings() {

        return settings;

    }

    // FUNCTIONS - GAME LOOP
    public void start() {

        gameThread = new Thread(this) {
        };

        initInputs();
        gameThread.start();

    }

    @Override
    public void run() {

        while (true) {

            // STATS
            statsFPS();
            statsUPS();

            // RENDER
            drawFrame();

            // UPDATE
            updateGame();

        }

    }

    // FUNCTIONS - INITIALIZERS
    private void initInputs() {

        mouse = new MouseTracker();
        keyboard = new KeyboardTracker();

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(keyboard);

        requestFocus();

    }

    private void initClasses() {

        gameScreen = new GameScreen(this);
        render = new Render(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);

    }

    // FUNCTIONS - DRAW/UPDATE
    private void drawFrame() {

        final long time = System.nanoTime();

        if (time - lastFrame >= timePerFrame) {

            lastFrame = time;
            ++frames;

            repaint();

        }

    }

    private void updateGame() {

        final long time = System.nanoTime();

        if (time - lastUpdate >= timePerUpdate) {

            lastUpdate = time;
            ++updates;

        }

    }

    // FUNCTIONS - STATS
    private void statsFPS() {

        final long time = System.currentTimeMillis();

        if (time - lastFrameTime >= 1000) {

            gameScreen.fpsCounter = frames;

            frames = 0;
            lastFrameTime = time;

        }

    }

    private void statsUPS() {

        final long time = System.currentTimeMillis();

        if (time - lastUpdateTime >= 1000) {

            gameScreen.upsCounter = updates;

            updates = 0;
            lastUpdateTime = time;

        }

    }

}
