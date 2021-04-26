package src;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BoardManager {
	public static BufferedImage draw() {
		ArrayList<MapTile[][]> maps = Game.getExpeditions();
		MapTile[][] map = maps.get(Game.getCurrentmap());

		BufferedImage board = new BufferedImage(50 * 32, 30 * 32, BufferedImage.TYPE_4BYTE_ABGR);

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 50; j++) {
				board.createGraphics().drawImage(map[i][j].getSprite(), j * 32, i * 32, 32, 32, null);
			}
		}
		return board;
	}
}
