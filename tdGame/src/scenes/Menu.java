package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import game.Game;
import game.GameScreen;
import static game.GameStates.*;
import ui.UIButton;

public class Menu extends GameScene implements SceneMethods {

    // VAR DECLARATIONS
    private UIButton bPlay, bSettings, bQuit;
    private ArrayList<UIButton> buttons = new ArrayList<>();

    // CONSTRUCTORS
    public Menu(Game game) {

        super(game);

        initButtons();

    }

    // FUNCTIONS
    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (int) GameScreen.size.getWidth(), (int) GameScreen.size.getHeight());
        drawButtons(g);

    }

    private void drawButtons(Graphics g) {

        for (UIButton b : buttons) {

            b.draw(g);

        }

    }

    private void initButtons() {

        buttons.add(
            bPlay = new UIButton(
                
                "Play",
                (int) GameScreen.size.getWidth() / 2 - 100,
                (int) GameScreen.size.getHeight() / 2 - 80,
                200,
                40
            
            )
        );

        buttons.add(
            bSettings = new UIButton(
                
                "Settings",
                (int) GameScreen.size.getWidth() / 2 - 100,
                (int) GameScreen.size.getHeight() / 2 - 20,
                200,
                40
            
            )
        );

        buttons.add(
            bQuit = new UIButton(
                
                "Quit",
                (int) GameScreen.size.getWidth() / 2 - 100,
                (int) GameScreen.size.getHeight() / 2 + 40,
                200,
                40
            
            )
        );

    }

    @Override
    public void mouseClicked(int x, int y) {
        
        if (bPlay.getBounds().contains(x, y)) {

            SetGameState(PLAYING);
            game.getGameScreen().setClicked(0);

        } else if (bSettings.getBounds().contains(x, y)) {

            SetGameState(SETTINGS);
            game.getGameScreen().setClicked(0);

        } else if (bQuit.getBounds().contains(x, y)) {

            game.getGameScreen().setClicked(0);
            System.exit(0);

        }
        
    }

    @Override
    public void mouseMoved(int x, int y) {

        for (UIButton b : buttons) {

            if (b.getBounds().contains(x, y)) {

                b.setHover(true);

            } else {

                b.setHover(false);

            }
            
        }
        
    }

    @Override
    public void mousePressed(int x, int y) {
        
        for (UIButton b : buttons) {

            if (b.getBounds().contains(x, y)) {

                b.setPressed(true);

            }
            
        }
        
    }

    @Override
    public void mouseReleased(int x, int y) {
        
        for (UIButton b : buttons) {

            b.setPressed(false);
            
        }
        
    }

}
