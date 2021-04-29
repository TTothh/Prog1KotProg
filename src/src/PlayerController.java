package src;

import src.Enums.Items;
import src.Enums.NPC;
import src.Enums.TileTypes;
import src.GUI.Screen.CrewScreen;
import src.GUI.Screen.StatScreen;
import src.NPC.Crew;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Ez az osztály végzi a játékos mozgatását és kezeli a dolgokat amik történnek mozgáskor
 */
public class PlayerController {
	Map current = Game.getExpeditions().get(Game.getCurrentmap());
	/**
	 * Mozgatjuk a játékost ha tudunk mozogni
	 * @param toMove
	 */
	public void move(Point toMove) {
		src.GUI.GameScreen gs = new src.GUI.GameScreen();

		if(Player.isCanMove() && canMove(toMove)) {
			Player.setPosition(new Point(toMove.x, toMove.y));
		}

		Game.getExpeditions().get(Game.getCurrentmap()).RevealMap();

		if(currentTile().equals("h") && Player.getInv().hasItem(Items.Machete)) {
			Player.setEnergy(Player.getEnergy() - (Player.getMovecost()));
			Player.getInv().removeItem(Items.Machete, 1);
			current.getTiles()[Player.getPosition().y][Player.getPosition().x].setType(TileTypes.GRASS);

			if(!current.getTiles()[Player.getPosition().y][Player.getPosition().x].isWet()) {
				current.getTiles()[Player.getPosition().y][Player.getPosition().x].setSprite(new ImageIcon("src/src/Assets/Tiles/Wet/Grass.png").getImage());
				current.getTiles()[Player.getPosition().y][Player.getPosition().x].setSpritepath("src/src/Assets/Tiles/Wet/Grass.png");
				BoardManager.draw();
			} else {
				current.getTiles()[Player.getPosition().y][Player.getPosition().x].setSprite(new ImageIcon("src/src/Assets/Tiles/Grass.png").getImage());
				current.getTiles()[Player.getPosition().y][Player.getPosition().x].setSpritepath("src/src/Assets/Tiles/Grass.png");
				BoardManager.draw();
			}
		} else if (currentTile().equals("h") && !Player.getInv().hasItem(Items.Machete)) {
			Player.setEnergy(Player.getEnergy() - (Player.getMovecost() * 2));
		} else {
			Player.setEnergy(Player.getEnergy() - Player.getMovecost());
		}

		if(currentTile().equals("j")) {
			if(Player.getCrew().getSize() < 3) {
				new CrewScreen(new Crew(3), new ArrayList<>(Arrays.asList(NPC.SCOUT, NPC.SHAMAN, NPC.SAGE)));
			}
		}

		if(currentTile().equals("m")) {
			System.out.println("Your winner");
		}

		if(Player.getEnergy() <= 0) {
			for (int i = 0; i < Player.getCrew().getSize(); i++) {
				if(Player.getCrew().getCrewMember(i).depart()) {
					Player.getCrew().removeCrewMember(Player.getCrew().getCrewMember(i).getUuid());
				}
			}
		}

		if(Player.getCrew().getSize() <= 0) {
			Game.setGameOver(true);
			Player.setCanMove(false);
		}

		Game.setTurn(Game.getTurn() + 1);
		StatScreen.update();
		gs.draw();
	}

	/**
	 * Visszadja hogy a desired koordináta valid-e
	 * @param p
	 * @return
	 */
	private boolean canMove(Point p) {
		Map map = Game.getExpeditions().get(Game.getCurrentmap());
		if(p.x >= 0 && p.x < map.getWIDTH() && p.y >= 0 && p.y < map.getHEIGHT()) {
			return map.getTiles()[p.y][p.x].isWalkable();
		}

		return false;
	}

	private String currentTile() {
		return TileTypes.getValue(current.getTiles()[Player.getPosition().y][Player.getPosition().x].getType());
	}
}
