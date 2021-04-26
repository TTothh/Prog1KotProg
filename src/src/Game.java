package src;

import src.GUI.MainMenu;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game {
	static ArrayList<MapTile[][]> expeditions = new ArrayList<>(5);
	static int currentmap = 0;
	BufferedImage CurrMap = LoadMap();

	public static void GenerateMaps() {
		for (int i = 0; i < 5; i++) {
			Map map = new Map(50, 30);
			map.Generate();
			expeditions.add(map.getTiles());
		}
	}

	public static BufferedImage LoadMap() {
		return BoardManager.draw();
	}

	public static void Init() {
		new MainMenu();
	}

	public static ArrayList<MapTile[][]> getExpeditions() {
		return expeditions;
	}

	public static int getCurrentmap() {
		return currentmap;
	}
}
