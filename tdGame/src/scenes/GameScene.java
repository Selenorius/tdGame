package scenes;

import game.Game;
import helpers.LevelBuild;

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

    // FUNCTIONS
    private void renderTile(int x, int y, int id, Graphics g) {

        BufferedImage sprite = tileManager.getTileSprite(id);
        if (sprite == null) return;
        g.drawImage(tileManager.getTileSprite(id), LevelBuild.pos(y), LevelBuild.pos(x), null);

    }

    private void renderEffect(int x, int y, int id, Graphics g) {

        BufferedImage sprite = tileManager.getEffectSprite(id);
        if (sprite == null) return;
        g.drawImage(tileManager.getEffectSprite(id), LevelBuild.pos(y), LevelBuild.pos(x), null);

    }

}
