package src;

import src.GUI.GameScreen;

import java.awt.*;
import java.util.Vector;

public class PlayerController {
	public void move(Point toMove) {
		GameScreen gs = new GameScreen();

		if(canMove(toMove)) {
			Player.setPosition(new Point(toMove.x, toMove.y));
		}

		Game.getExpeditions().get(Game.getCurrentmap()).RevealMap();
		Player.setEnergy(Player.getEnergy() - 1);
		System.out.println(Game.getExpeditions().get(Game.getCurrentmap()).getTiles()[Player.getPosition().y][Player.getPosition().x].getType());


		gs.draw();
	}

	private boolean canMove(Point p) {
		Map map = Game.getExpeditions().get(Game.getCurrentmap());
		if(p.x >= 0 && p.x < map.getWIDTH() && p.y >= 0 && p.y < map.getHEIGHT()) {
			return map.getTiles()[p.y][p.x].isWalkable();
		}

		return false;
	}
}
