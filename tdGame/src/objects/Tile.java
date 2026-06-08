package objects;

import java.awt.image.BufferedImage;

public class Tile {

    // VAR DECLARATIONS
    private BufferedImage sprite;

    // CONSTRUCTORS
    public Tile(BufferedImage sprite) {

        this.sprite = sprite;

    }

    // GETTERS
    public BufferedImage getSprite() {

        return sprite;

    }

}
