package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpers.LevelBuild;
import helpers.LoadSave;
import objects.Tile;

public class TileManager {

    // VAR DECLARATIONS
    private Tile SAND, ROAD, WATER;
    private BufferedImage atlas;
    private ArrayList<Tile> tiles = new ArrayList<>(), effects = new ArrayList<>();
    
    // CONSTRUCTORS
    public TileManager() {

        loadAtlas();
        createTiles();
        createEffects();

    }

    // FUNCTIONS
    private void loadAtlas() {
        
        atlas = LoadSave.loadImg("res/tdGameSpriteAtlas.png");

    }

    private void createTiles() {
        
        tiles.add(null);
        tiles.add(SAND = new Tile(loadSprite(8, 1)));

    }

    private void createEffects() {

        effects.add(null);
        effects.add(ROAD = new Tile(loadSprite(9, 0)));
        effects.add(WATER = new Tile(loadSprite(0, 0)));

    }

    public BufferedImage getTileSprite(int id) {

        return tiles.get(id).getSprite();

    }

    public BufferedImage getEffectSprite(int id) {

        return effects.get(id).getSprite();

    }

    private BufferedImage loadSprite(int xPos, int yPos) {
        
        return atlas.getSubimage(xPos * LevelBuild.tileSize, yPos * LevelBuild.tileSize, LevelBuild.tileSize, LevelBuild.tileSize);

    }

}
