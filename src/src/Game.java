package src;

import src.Enums.Items;
import src.GUI.GameScreen;
import src.InventoryManagement.Inventory;
import src.InventoryManagement.Item;
import src.Locations.*;
import src.NPC.Crew;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * A játék. Számontart alapvető dolgokat.
 */
public class Game {
	static ArrayList<Map> expeditions = new ArrayList<>(5);
	static int currentmap = 0;

	static BufferedImage CurrMap;
	static Player player = new Player();

	private static Point pyramid;
	private static Point ship;
	private static Point dock;
	private static int turn = 0;
	private static boolean GameOver = false;

	/**
	 * Legenerálja a mapot
	 */
	public static void GenerateMap() {
		Map map = new Map(50, 30);
		map.Generate();

		pyramid = Pyramid.getPosition();
		ship = PlayerShip.getPosition();
		dock = Dock.getPosition();

		expeditions.add(map);
		CurrMap = LoadMap();
	}

	/**
	 * a boardmanager-rel elkészíti a jelenlegi pálya képét
	 *
	 * @return
	 */
	public static BufferedImage LoadMap() {
		return BoardManager.draw();
	}

	/**
	 *	Betölti a mapot, beállítja a karakter kezdő helyét és lérehozza a főmenüt
	 */
	public void Init() {
		GenerateMap();
		setupPlayer();
	}

	public static void setupPlayer() {
		Player.setMoney(Player.getMoney() + 250);
		Player.setPosition(new Point(Dock.getPosition().y, Dock.getPosition().x));
		Player.setCrew(new Crew(3));
		Player.setInv(new Inventory(8));
		Player.getInv().addItem(new Item(Items.Machete), 5);
		Player.getInv().fillInv();
		Player.setFow(2);
		Player.setCanMove(true);
	}

	/**
	 * Új map ha megnyerjük az előzőt
	 */
	public void win() {
		Game.currentmap += 1;
		Init();
		new GameScreen().Init();
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

	public static boolean isGameOver() {
		return GameOver;
	}

	public static void setGameOver(boolean gameOver) {
		GameOver = gameOver;
	}
}
