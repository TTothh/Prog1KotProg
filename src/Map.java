import Enums.TileTypes;
import JavaReImplementations.Random;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays.*;
import java.util.Iterator;
import java.util.logging.Level;


public class Map {
	private int WIDTH;
	private int HEIGHT;

	private MapTile[][] tiles;

	Random r = new Random();

	public Map(int WIDTH, int HEIGHT) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;

		tiles = new MapTile[HEIGHT][WIDTH];
	}

	public void Generate() {
		GenerateSea();
		GenerateLandMass();
	}

	private void GenerateSea() {
		Logging.Log("Generating sea", "Setup.log" , this.getClass().getName(), Level.INFO);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				tiles[i][j] = new MapTile();
			}
		}
	}

	//TODO: other generate other type of tiles

	private void GenerateLandMass() {
		Logging.Log("Generating land", "Setup.log" , getClass().getName(), Level.INFO);
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

	private void GenerateLakes() {
		int noLakes = r.NextRandom(2, 5);
		int[] sizeofLakes = new int[noLakes];
		Point curr;
		ArrayList<Point> neighbours;

		for (int i = 0; i < noLakes; i++) {
			sizeofLakes[i] = r.NextRandom(4, 9);
		}

		for (int i = 0; i < noLakes; i++) {
			curr = getNewLakeCoords();

			for (int j = 0; j < sizeofLakes[i]; j++) {
				neighbours = getNeighbours(curr);
			}
		}
	}

	private Point getNewLakeCoords() {
		Point curr = new Point(0, 0);

		while (tiles[curr.x][curr.y].getType()  != TileTypes.GRASS) {
			curr.x = r.NextRandom(0, HEIGHT - 1);
			curr.y = r.NextRandom(0, WIDTH - 1);
		}

		return curr;
	}

	private java.util.ArrayList<Point> getNeighbours(Point curr) {
		java.util.ArrayList<Point> nbs = new java.util.ArrayList<>();
		for (int i = curr.y - 1; i <= curr.y + 1; i++) {
			for (int j = curr.x - 1; j <= curr.x + 1; j++) {
				nbs.add(new Point(i, j));
			}
		}

		nbs.removeIf(current -> tiles[current.y][current.x].getType() == TileTypes.LAKE);

		return nbs;
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
