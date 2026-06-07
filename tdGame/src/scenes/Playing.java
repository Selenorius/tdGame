package scenes;

import java.awt.Graphics;

import game.Game;

public class Playing extends GameScene implements SceneMethods {

    //CONSTRUCTORS
    public Playing(Game game) {

        super(game);

    }

    //FUNCTIONS
    @Override
    public void render(Graphics g) {

        game.getRender().drawGrid(game.getRender().sprites.get(28), g);
        
    }

}
