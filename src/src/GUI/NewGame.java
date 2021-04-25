package src.GUI;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class NewGame extends MenuButton{
	public NewGame(String text) {
		super(text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new GameScreen();
	}
}
