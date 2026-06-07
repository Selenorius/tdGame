package render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.Game;
import game.GameStates;

public class Render {

    // CONST DECLARATIONS
    public final int tileSize = 32;

    // VAR DECLARATIONS
    Game game;
    public BufferedImage img;
    public ArrayList<BufferedImage> sprites = new ArrayList<>();
    private final int tileAmountX,
            tileAmountY;
    public int spriteAmountX;
    public int spriteAmountY;

    // CONSTRUCTORS
    public Render(final Game game) {

        tileAmountX = game.getSize().width / tileSize;
        tileAmountY = game.getSize().height / tileSize;
        this.img = game.getSpriteAtlas();
        spriteAmountX = img.getWidth() / tileSize;
        spriteAmountY = img.getHeight() / tileSize;
        this.game = game;

        loadSprites();

    }

    public ArrayList<BufferedImage> getSprites() {

        return sprites;

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

    public void loadSprites() {

        for (int row = 0; row < spriteAmountY; ++row) {

            for (int col = 0; col < spriteAmountX; ++col) {

                sprites.add(img.getSubimage(pos(col), pos(row), tileSize, tileSize));

            }

        }

    }

    public void drawGrid(BufferedImage img, final Graphics g) {

        for (int row = 0; row < tileAmountX; ++row) {

            for (int col = 0; col < tileAmountY; ++col) {

                g.drawImage(img, pos(col), pos(row), null);

            }

        }

    }

    // HELPERS
    public int pos(final int i) {

        return i * tileSize;

    }

}
