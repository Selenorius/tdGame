package scenes;

import java.awt.Graphics;

import game.Game;

public class Menu extends GameScene implements SceneMethods {

    //CONSTRUCTORS
    public Menu(Game game) {

        super(game);

    }

    //FUNCTIONS
    @Override
    public void render(Graphics g) {

        game.getRender().drawGrid(game.getRender().sprites.get(19), g);
        
    }

}
