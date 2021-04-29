package src;

import src.GUI.MainMenu;

public class Main {
	/**
	 * A Game.Init beállítja az alapdolgokat és generálja az főmenüt
	 *
	 */
	public static void main(String[] args) {
		new MainMenu();
		Game game = new Game();
		game.Init();
	}
}
