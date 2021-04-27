package src;

import src.GUI.MainMenu;
import src.Locations.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
	static ArrayList<Map> expeditions = new ArrayList<>(5);
	static int currentmap = 0;

	BufferedImage CurrMap;
	static Player player = new Player();

	private HashMap<Point, Altar> altars;
	private HashMap<Point, Village> villages;
	private Point pyramid;
	private Point ship;
	private Point dock;

	public void GenerateMap() {
		Map map = new Map(50, 30);
		map.Generate();

		altars = map.getAltars();
		villages = map.getVillages();
		pyramid = Pyramid.getPosition();
		ship = PlayerShip.getPosition();
		dock = Dock.getPosition();

		expeditions.add(map);
		CurrMap = LoadMap();
	}

	public static BufferedImage LoadMap() {
		return BoardManager.draw();
	}

	public void Init() {
		GenerateMap();
		Player.setPosition(new Point(Dock.getPosition().y, Dock.getPosition().x));
		new MainMenu();
	}

	public static ArrayList<Map> getExpeditions() {
		return expeditions;
	}

	public static int getCurrentmap() {
		return currentmap;
	}
}
