package src.GUI;

import src.BoardManager;
import src.Game;

import java.awt.event.ActionEvent;

/**
 * A new game gomb. megnyomására elindul a játék és betöltődik a térkép
 */
public class NewGame extends MenuButton{
	public NewGame(String text) {
		super(text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Game.setupPlayer();
		new GameScreen().Init();
	}
}
