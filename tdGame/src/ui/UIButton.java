package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.GameScreen;

public class UIButton {

    // VAR DECLARATIONS
    private int
        x,
        y,
        width,
        height;
    private String text, selectText;
    private Rectangle bounds;
    private boolean hover,
        pressed;

    // CONSTRUCTORS
    public UIButton(String text, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        selectText = "> " + text + " <";

        bounds = new Rectangle(x, y, width, height);
    }

    // GETTERS
    public Rectangle getBounds() {

        return bounds;

    }

    // SETTERS
    public void setHover(boolean hover) {

        this.hover = hover;

    }

    public void setPressed(boolean pressed) {

        this.pressed = pressed;

    }

    public void draw(Graphics g) {
        String tempText;

        // Body
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);

        // Border
        if (hover) {

            g.setColor(Color.YELLOW);
            tempText = selectText;
        
        } else {

            g.setColor(Color.WHITE);
            tempText = text;

        }
        if (pressed) {

            g.drawRect(

                x + width / 32,
                y + height / 32,
                width - width / 16,
                height - height / 16
            
            );

        } else {

            g.drawRect(x, y, width, height);

        }

        // Text
        g.setFont(GameScreen.UIFont);
        GameScreen.drawText(tempText, x + width / 2, y + height / 2, g);

    }

}
