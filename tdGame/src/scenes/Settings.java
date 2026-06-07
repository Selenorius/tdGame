package scenes;

import java.awt.Graphics;

import game.Game;

public class Settings extends GameScene implements SceneMethods {

    //CONSTRUCTORS
    public Settings(Game game) {

        super(game);

    }

    //FUNCTIONS
    @Override
    public void render(Graphics g) {

        game.getRender().drawGrid(game.getRender().sprites.get(29), g);
        
    }

}
