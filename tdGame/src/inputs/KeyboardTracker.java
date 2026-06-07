package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static game.GameStates.*;

public class KeyboardTracker implements KeyListener {

	//FUNCTIONS
	@Override
	public void keyPressed(final KeyEvent e) {
		
		switch (e.getKeyCode()) {

			case KeyEvent.VK_1:

				gameState = MENU;

				break;

			case KeyEvent.VK_2:

				gameState = PLAYING;

				break;

			case KeyEvent.VK_3:

				gameState = SETTINGS;

				break;

		}

	}

	@Override
	public void keyReleased(final KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(final KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
