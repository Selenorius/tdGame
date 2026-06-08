package render;

import java.awt.Graphics;

import game.Game;
import game.GameStates;

public class Render {

    // VAR DECLARATIONS
    Game game;

    // CONSTRUCTORS
    public Render(final Game game) {

        this.game = game;

    }

    // FUNCTIONS
    public void render(final Graphics g) {

        switch (GameStates.gameState) {

            case MENU:

                game.getMenu().render(g);

                break;

            case PLAYING:

                game.getPlaying().render(g);

                break;

            case SETTINGS:

                game.getSettings().render(g);

                break;

        }

    }

}
