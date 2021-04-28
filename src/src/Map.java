package src;

import src.Enums.TileTypes;
import src.JavaReImplementations.Random;
import src.Locations.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;


public class Map {
	private final int WIDTH;
	private final int HEIGHT;

	private final MapTile[][] tiles;

	private final HashMap<Point, Altar> altars = new HashMap<>();
	private final HashMap<Point, Village> villages = new HashMap<>();

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
		GenerateWet();
		GenerateDockandShip();
	}

	private void GenerateSea() {
		Logging.Log("Generating sea", "Setup.log", this.getClass().getName(), Level.INFO);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				tiles[i][j] = new MapTile(true, true, false, TileTypes.SEA, "Sea.png");
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
					tiles[i][j] = new MapTile(false, false, true, TileTypes.GRASS, "Grass.png");
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
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Collections.singletonList(TileTypes.GRASS));

		for (int i = 0; i < noLakes; i++) {
			sizeofLakes[i] = r.NextRandom(5, 13);
		}

		for (int i = 0; i < noLakes; i++) {
			curr = getNewValidCoords(isAllowedOn);
			tiles[curr.y][curr.x] = new MapTile(true, false, false, TileTypes.LAKE, "Lake.png");

			for (int j = 0; j < sizeofLakes[i]; j++) {
				neighbours = getNeighbours(curr);
				next = neighbours.get(r.NextRandom(0, neighbours.size() - 2));

				try {
					tiles[next.y][next.x] = new MapTile(true, false, false, TileTypes.LAKE, "Lake.png");
				} catch (Exception e) {
					System.out.println(next.y + " : " + next.x);
				}
				curr = next;
			}
		}
	}

	private void GenerateMountains() {
		Logging.Log("Generating Mountains", "Setup.log", getClass().getName(), Level.INFO);
		int noMountains = r.NextRandom(15, 28);
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS, TileTypes.LAKE, TileTypes.JUNGLE));
		Point newMountain;

		for (int i = 0; i < noMountains; i++) {
			newMountain = getNewValidCoords(isAllowedOn);
			tiles[newMountain.y][newMountain.x] = new MapTile(false, false, false, TileTypes.MOUNTAIN, "Mountain_0.png");
		}
	}

	private void GenerateCaves() {
		Logging.Log("Generating Caves", "Setup.log", getClass().getName(), Level.INFO);
		int noCaves = r.NextRandom(6, 20);
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS, TileTypes.LAKE, TileTypes.JUNGLE));
		Point newCave;

		for (int i = 0; i < noCaves; i++) {
			newCave = getNewValidCoords(isAllowedOn);
			tiles[newCave.y][newCave.x] = new MapTile(false, false, true, TileTypes.CAVE, "Cave.png");
		}
	}

	private void GenerateAltars() {
		Logging.Log("Generating Altars", "Setup.log", getClass().getName(), Level.INFO);
		int noAltars = r.NextRandom(3, 13);
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.GRASS, TileTypes.JUNGLE));
		Point newAltar;

		for (int i = 0; i < noAltars; i++) {
			newAltar = getNewValidCoords(isAllowedOn);
			tiles[newAltar.y][newAltar.x] = new MapTile(false, false, true, TileTypes.ALTAR, "Altar.png");
			altars.put(new Point(newAltar.x, newAltar.y), new Altar());
		}
	}

	private void GenerateJungle() {
		Logging.Log("Generating Jungles", "Setup.log", getClass().getName(), Level.INFO);
		int noJungles = r.NextRandom(5, 10);
		int[] sizeofJungles = new int[noJungles];
		Point curr;
		Point next = new Point(0, 0);
		ArrayList<Point> neighbours;
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Collections.singletonList(TileTypes.GRASS));

		for (int i = 0; i < noJungles; i++) {
			sizeofJungles[i] = r.NextRandom(20, 30);
		}

		for (int i = 0; i < noJungles; i++) {
			curr = getNewValidCoords(isAllowedOn);
			tiles[curr.y][curr.x] = new MapTile(true, false, true, TileTypes.JUNGLE, "Jungle.png");

			for (int j = 0; j < sizeofJungles[i]; j++) {
				neighbours = getNeighbours(curr);
				try {
					next = neighbours.get(r.NextRandom(0, neighbours.size() - 2));
				} catch (Exception ignored) {
				}
				try {
					tiles[next.y][next.x] = new MapTile(true, false, true, TileTypes.JUNGLE, "Jungle.png");
				} catch (Exception ignored) {
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
			tiles[curr.y][curr.x] = new MapTile(true, false, true, TileTypes.VILLAGE, "Village.png");

			for (int j = 0; j < sizeofVillages[i]; j++) {
				neighbours = getNeighbours(curr);
				next = neighbours.get(r.NextRandom(0, neighbours.size() - 2));
				try {
					tiles[next.y][next.x] = new MapTile(true, false, true, TileTypes.VILLAGE, "Village.png");
					villages.put(new Point(next.x, next.y), new Village(2));
				} catch (Exception ignored) {
				}
				curr = next;
			}
		}
	}

	private void GeneratePyramid() {
		ArrayList<TileTypes> isAllowedOn = new ArrayList<>(Arrays.asList(TileTypes.JUNGLE, TileTypes.LAKE, TileTypes.VILLAGE));
		Point pyramid = getNewValidCoords(isAllowedOn);
		tiles[pyramid.y][pyramid.x] = new MapTile(false, false, true, TileTypes.GOLDENPYRAMID, "GoldenPyramid.png");
		new Pyramid(new Point(pyramid.x, pyramid.y));
	}

	private void GenerateDockandShip() {
		Point pos = new Point(r.NextRandom(0, HEIGHT - 1), 0);

loop:
		for (int j = 0; j < WIDTH; j++) {
			if (tiles[pos.x][j].getType() != TileTypes.SEA) {
				tiles[pos.x][j] = new MapTile(false, true, true, TileTypes.DOCK, "Dock.png");
				tiles[pos.x][j - 1] = new MapTile(false, true, true, TileTypes.PLAYERSHIP, "Ship.png");

				new Dock(new Point(pos.x, j));
				Player.setPosition(new Point(pos.x, j));
				new PlayerShip(new Point(pos.x, (j - 1)));
				break loop;
			}
		}
	}

	private void GenerateWet() {
		ArrayList<Point> neighbours;

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (tiles[i][j].getType() == TileTypes.LAKE) {
					neighbours = getNeighbours(new Point(j, i));

					for (Point neighbour : neighbours) {
						MapTile curr = tiles[neighbour.y][neighbour.x];
						if (curr.isWalkable()) {
							tiles[neighbour.y][neighbour.x].setWet(true);
							System.out.println(tiles[neighbour.y][neighbour.x].getSpritepath());
						}
					}
				}
			}
		}
	}

	public void RevealMap() {
		Point center = Player.getPosition();
		MapTile curr;
		for (int i = center.y - Player.getFow(); i < center.y + Player.getFow(); i++) {
			if (i < 0 || i == HEIGHT) {
				continue;
			}
			for (int j = center.x - Player.getFow(); j < center.x + Player.getFow(); j++) {
				if (j < 0 || j == WIDTH) {
					continue;
				}

				curr = tiles[i][j];
				curr.setSprite(new ImageIcon(curr.getSpritepath()).getImage());
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
		} catch (Exception ignored) {
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
					if (tiles[i][j].getType() != TileTypes.SEA) {
						nbs.add(new Point(j, i));
					}
				} catch (Exception e) {
					System.out.println(i + " : " + j);
				}
			}
		}
		return nbs;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public MapTile[][] getTiles() {
		return this.tiles;
	}

	public HashMap<Point, Altar> getAltars() {
		return altars;
	}

	public HashMap<Point, Village> getVillages() {
		return villages;
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
