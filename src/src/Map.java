package src;

import src.Enums.TileTypes;
import src.JavaReImplementations.Random;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
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
		GenerateLakes();
		GenerateJungle();
		GenerateMountains();
		GenerateCaves();
		GenerateVillages();
		GenerateAltars();
		GeneratePyramid();
	}

	private void GenerateSea() {
		Logging.Log("Generating sea", "Setup.log", this.getClass().getName(), Level.INFO);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				tiles[i][j] = new MapTile();
			}
		}
	}

	private void GenerateLandMass() {
		Logging.Log("Generating land", "Setup.log", getClass().getName(), Level.INFO);
		int DELTA = 3;
		int linePos = (int) Math.floor((double) WIDTH / 2) - 10;
		Point previous = new Point(r.NextRandom(linePos - DELTA, linePos + DELTA), 0);
		Point current;

		for (int i = 0; i < HEIGHT; i++) {
			current = new Point(r.NextRandom(previous.x - 1, previous.x + 1), i);

			for (int j = 0; j < WIDTH; j++) {
				if (j >= current.x) {
					tiles[i][j] = new MapTile(false, false, TileTypes.GRASS);
				}
			}

			previous = current;
		}
	}

	private void GenerateLakes() {
		Logging.Log("Generating Lakes", "Setup.log", getClass().getName(), Level.INFO);
		int noLakes = r.NextRandom(2, 5);
		int[] sizeofLakes = new int[noLakes];
		Point curr;
		Point next;
		ArrayList<Point> neighbours;
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS));

		for (int i = 0; i < noLakes; i++) {
			sizeofLakes[i] = r.NextRandom(5, 13);
		}

		for (int i = 0; i < noLakes; i++) {
			curr = getNewValidCoords(isAllowedOn);
			tiles[curr.y][curr.x] = new MapTile(true, false, TileTypes.LAKE);

			for (int j = 0; j < sizeofLakes[i]; j++) {
				neighbours = getNeighbours(curr);
				next = neighbours.get(r.NextRandom(0, neighbours.size() - 2));
				try {
					tiles[next.y][next.x] = new MapTile(true, false, TileTypes.LAKE);
				} catch (Exception e) {
					System.out.println(next.y + " : " + next.x);
				}
				curr = next;
			}
		}
	}

	private Point getNewValidCoords(ArrayList<TileTypes> allowedtiles) {
		Point curr = new Point(0, 0);

		try {
			while (!allowedtiles.contains(tiles[curr.y][curr.x].getType())) {
				curr.x = r.NextRandom(0, WIDTH - 1);
				curr.y = r.NextRandom(0, HEIGHT - 1);
			}
		} catch (Exception e) {
			System.out.println("asd");
		}

		return curr;
	}

	private java.util.ArrayList<Point> getNeighbours(Point curr) {
		ArrayList<Point> nbs = new ArrayList<>();

		for (int i = curr.y - 1; i <= (curr.y + 1); i++) {
			if (i < 0 || i == HEIGHT) {
				continue;
			}
			for (int j = curr.x - 1; j <= curr.x + 1; j++) {
				if (j < 0 || j == WIDTH || (curr.y == i && curr.x == j)) {
					continue;
				}
				try {
					if (tiles[i][j].getType() != TileTypes.LAKE) {
						nbs.add(new Point(j, i));
					}
				} catch (Exception e) {
					System.out.println(i + " : " + j);
				}
			}
		}

		return nbs;
	}

	private void GenerateMountains() {
		Logging.Log("Generating Mountains", "Setup.log", getClass().getName(), Level.INFO);
		int noMountains = r.NextRandom(15, 28);
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS, TileTypes.LAKE, TileTypes.JUNGLE));
		Point newMountain;

		for (int i = 0; i < noMountains; i++) {
			newMountain = getNewValidCoords(isAllowedOn);
			tiles[newMountain.y][newMountain.x] = new MapTile(false, false, TileTypes.MOUNTAIN);
		}
	}

	private void GenerateCaves() {
		Logging.Log("Generating Caves", "Setup.log", getClass().getName(), Level.INFO);
		int noCaves = r.NextRandom(6, 20);
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS, TileTypes.LAKE, TileTypes.JUNGLE));
		Point newCave;

		for (int i = 0; i < noCaves; i++) {
			newCave = getNewValidCoords(isAllowedOn);
			tiles[newCave.y][newCave.x] = new MapTile(false, false, TileTypes.CAVE);
		}
	}


	private void GenerateAltars() {
		Logging.Log("Generating Altars", "Setup.log", getClass().getName(), Level.INFO);
		int noAltars = r.NextRandom(3, 13);
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS, TileTypes.JUNGLE));
		Point newCave;

		for (int i = 0; i < noAltars; i++) {
			newCave = getNewValidCoords(isAllowedOn);
			tiles[newCave.y][newCave.x] = new MapTile(false, false, TileTypes.ALTAR);
		}
	}

	private void GenerateJungle() {
		Logging.Log("Generating Jungles", "Setup.log", getClass().getName(), Level.INFO);
		int noJungles = r.NextRandom(5, 10);
		int[] sizeofJungles = new int[noJungles];
		Point curr;
		Point next;
		ArrayList<Point> neighbours;
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS));

		for (int i = 0; i < noJungles; i++) {
			sizeofJungles[i] = r.NextRandom(20, 30);
		}

		for (int i = 0; i < noJungles; i++) {
			curr = getNewValidCoords(isAllowedOn);
			tiles[curr.y][curr.x] = new MapTile(true, false, TileTypes.JUNGLE);

			for (int j = 0; j < sizeofJungles[i]; j++) {
				neighbours = getNeighbours(curr);
				next = neighbours.get(r.NextRandom(0, neighbours.size() - 2));
				try {
					tiles[next.y][next.x] = new MapTile(true, false, TileTypes.JUNGLE);
				} catch (Exception e) {
					System.out.println(next.y + " : " + next.x);
				}
				curr = next;
			}
		}
	}

	private void GenerateVillages() {
		Logging.Log("Generating Villages", "Setup.log", getClass().getName(), Level.INFO);
		int noVillages = r.NextRandom(10, 16);
		int[] sizeofVillages = new int[noVillages];
		Point curr;
		Point next;
		ArrayList<Point> neighbours;
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS, TileTypes.JUNGLE, TileTypes.LAKE));

		for (int i = 0; i < noVillages; i++) {
			sizeofVillages[i] = r.NextRandom(2, 5);
		}

		for (int i = 0; i < noVillages; i++) {
			curr = getNewValidCoords(isAllowedOn);
			tiles[curr.y][curr.x] = new MapTile(true, false, TileTypes.VILLAGE);

			for (int j = 0; j < sizeofVillages[i]; j++) {
				neighbours = getNeighbours(curr);
				next = neighbours.get(r.NextRandom(0, neighbours.size() - 2));
				try {
					tiles[next.y][next.x] = new MapTile(true, false, TileTypes.VILLAGE);
				} catch (Exception e) {
					System.out.println(next.y + " : " + next.x);
				}
				curr = next;
			}
		}
	}

	private void GeneratePyramid() {
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.JUNGLE, TileTypes.LAKE,TileTypes.VILLAGE));
		Point pyramid = getNewValidCoords(isAllowedOn);
		tiles[pyramid.y][pyramid.x] = new MapTile(false, false, TileTypes.GOLDENPYRAMID);
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				out.append(tiles[i][j].getType().getValue(tiles[i][j].getType())).append("\t"); //Jank, but working. src.Enums in Java suck
			}
			out.append("\n");
		}

		return out.toString();
	}
}
