import Enums.TileTypes;
import JavaReImplementations.Random;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;


public class Map {
	private int WIDTH;
	private int HEIGHT;

	private MapTile[][] tiles;

	public Map(int WIDTH, int HEIGHT) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;

		tiles = new MapTile[HEIGHT][WIDTH];
	}

	public void Generate() throws IOException {
		GenerateSea();
		GenerateLandMass();
	}

	private void GenerateSea() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				tiles[i][j] = new MapTile();
			}
		}
	}

	//TODO: other generate other type of tiles

	private void GenerateLandMass() throws IOException {
		Logging.Log("Generating sea", "Setup.log" , this.getClass().getName(), Level.INFO);
		Random r = new Random();
		int DELTA = 3;
		int linePos = (int) Math.floor((double) WIDTH / 2) - 10;
		Point previous = new Point(r.NextRandom(linePos - DELTA, linePos + DELTA), 0);
		Point current;

		for (int i = 0; i < HEIGHT; i++) {
			current = new Point(r.NextRandom(previous.x - 1, previous.x + 2), i);

			for (int j = 0; j < WIDTH; j++) {
				if(j >= current.x) {
					tiles[i][j] = new MapTile(false, false, TileTypes.GRASS);
				}
			}

			previous = current;
		}
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				out.append(tiles[i][j].getType().getValue(tiles[i][j].getType())).append("\t"); //Jank, but working. Enums in Java suck
			}
			out.append("\n");
		}

		return out.toString();
	}
}
