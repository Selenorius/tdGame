package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;
import helpers.LevelBuild;
import managers.TileManager;

public class Playing extends GameScene implements SceneMethods {

    // VAR DECLARATIONS
    private int[][] level, effects;
    private TileManager tileManager;

    // CONSTRUCTORS
    public Playing(Game game) {

        super(game);

        level = LevelBuild.getLevelData();
        effects = LevelBuild.getEffectData();
        tileManager = new TileManager();

    }

    // FUNCTIONS
    @Override
    public void render(Graphics g) {

        int tileId, effectId;

        for (int row = 0; row < level.length; ++row) {

            for (int col = 0; col < level[row].length; ++col) {

                tileId = level[col][row];
                effectId = effects[col][row];
                renderTile(col, row, tileId, g);
                renderEffect(col, row, effectId, g);

            }

        }

    }

    private void renderTile(int x, int y, int id, Graphics g) {

        BufferedImage sprite = tileManager.getTileSprite(id);
        g.drawImage(tileManager.getTileSprite(id), LevelBuild.pos(y), LevelBuild.pos(x), null);

    }

    private void renderEffect(int x, int y, int id, Graphics g) {

        BufferedImage sprite = tileManager.getEffectSprite(id);
        g.drawImage(tileManager.getEffectSprite(id), LevelBuild.pos(y), LevelBuild.pos(x), null);

    }

}
