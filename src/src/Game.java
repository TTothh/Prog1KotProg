package src;

import java.util.ArrayList;

public class Game {
	ArrayList<Map> expeditions = new ArrayList<>();
	Map map = new Map(50, 30);

	public void NewGame() {
		map.Generate();
	}
}
