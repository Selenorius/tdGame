package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpers.LevelBuild;
import helpers.LoadSave;
import objects.Tile;

public class TileManager {

    // VAR DECLARATIONS
    private Tile EMPTY, GRASS, ROAD, WATER, ROCK;
    private BufferedImage atlas;
    private ArrayList<Tile> tiles = new ArrayList<>(), effects = new ArrayList<>();
    
    // CONSTRUCTORS
    public TileManager() {

        loadAtlas();
        EMPTY = new Tile(loadSprite(9, 9));
        createTiles();
        createEffects();

    }

    // FUNCTIONS
    private void loadAtlas() {
        
        atlas = LoadSave.loadImg("res/tdGameSpriteAtlas.png");

    }

    private void createTiles() {
        
        tiles.add(EMPTY);
        tiles.add(GRASS = new Tile(loadSprite(8, 1)));

    }

    private void createEffects() {

        effects.add(EMPTY);
        effects.add(ROAD = new Tile(loadSprite(9, 0)));
        effects.add(WATER = new Tile(loadSprite(4, 0)));
        effects.add(ROCK = new Tile(loadSprite(8, 4)));

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
