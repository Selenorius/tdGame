package scenes;

import game.Game;

public class GameScene {

    // VAR DECLARATIONS
    protected final Game game;

    // CONSTRUCTORS
    protected GameScene(final Game game) {

        this.game = game;

    }

    // GETTERS
    public Game getGame() {

        return game;

    }

}
