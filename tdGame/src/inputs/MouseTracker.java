package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.Game;
import game.GameStates;

public class MouseTracker implements MouseListener, MouseMotionListener {

	// VAR DECLARATIONS
	private Game game;

	// CONSTRUCTORS
	public MouseTracker(Game game) {

		this.game = game;

	}

	// FUNCTIONS
	@Override
	public void mouseClicked(final MouseEvent e) {
		
		game.getGameScreen().mouseClicked(e.getX(), e.getY());
		if (e.getButton() == MouseEvent.BUTTON1) {

			switch (GameStates.gameState) {

				case MENU:

					game.getMenu().mouseClicked(e.getX(), e.getY());
					break;

				case PLAYING:

					break;

				case SETTINGS:

					break;

				default:

					break;

			}

		}

	}

	@Override
	public void mouseEntered(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(final MouseEvent e) {

		switch (GameStates.gameState) {

				case MENU:

					game.getMenu().mousePressed(e.getX(), e.getY());
					break;

				case PLAYING:

					break;

				case SETTINGS:

					break;

				default:

					break;

			}

	}

	@Override
	public void mouseReleased(final MouseEvent e) {
		
		game.getMenu().mouseReleased(e.getX(), e.getY());

	}

	@Override
	public void mouseDragged(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(final MouseEvent e) {
		
		switch (GameStates.gameState) {

			case MENU:

				game.getMenu().mouseMoved(e.getX(), e.getY());
				break;

			case PLAYING:

				break;

			case SETTINGS:

				break;

			default:

				break;

		}

	}

}
