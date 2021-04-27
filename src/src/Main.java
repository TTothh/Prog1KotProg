package src;

import src.GUI.MainMenu;

import java.awt.*;
import java.util.ArrayList;

public class Main {
	public static final int SCREENWIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREENHEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	public static void main(String[] args) {
		Game game = new Game();
		game.Init();
	}
}
