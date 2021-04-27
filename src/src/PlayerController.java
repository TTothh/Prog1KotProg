package src;

import java.awt.*;
import java.util.Vector;

public class PlayerController {
	public void move(Point toMove) {
		if(canMove(toMove)) {
			Player.setPosition(new Point(toMove.x, toMove.y));
		}
	}

	private boolean canMove(Point p) {
		Map map = Game.getExpeditions().get(Game.getCurrentmap());
		if(p.x >= 0 && p.x < map.getWIDTH() && p.y >= 0 && p.y < map.getHEIGHT()) {
			return map.getTiles()[p.y][p.x].isWalkable();
		}

		return false;
	}
}
