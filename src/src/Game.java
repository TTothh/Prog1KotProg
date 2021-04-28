package src;

import src.GUI.MainMenu;
import src.Locations.*;
import src.NPC.Crew;

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
	private static int turn = 0;

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
		Player.setCrew(new Crew(3));
		new MainMenu();
	}

	public static ArrayList<Map> getExpeditions() {
		return expeditions;
	}

	public static int getCurrentmap() {
		return currentmap;
	}

	public static int getTurn() {
		return turn;
	}

	public static void setTurn(int turn) {
		Game.turn = turn;
	}
}
