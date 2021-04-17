import Enums.TileTypes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Map {
	private int WIDTH;
	private int HEIGHT;

	private MapTile[][] tiles;

	public Map(int WIDTH, int HEIGHT) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;

		tiles = new MapTile[HEIGHT][WIDTH];
	}

	public void Generate() {
		GenerateSea();
	}

	private void GenerateSea() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				tiles[i][j] = new MapTile();
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				out.append(tiles[i][j].getType().getValue(tiles[i][j].getType())); //Jank, but working. Enums in Java suck
			}
			out.append("\n");
		}

		return out.toString();
	}
}
