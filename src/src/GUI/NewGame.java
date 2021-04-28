package src.GUI;

import src.BoardManager;
import src.Game;

import java.awt.event.ActionEvent;

public class NewGame extends MenuButton{
	public NewGame(String text) {
		super(text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BoardManager.draw();
		new GameScreen().Init();
	}
}
