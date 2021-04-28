package src;

import src.Enums.TileTypes;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class MapTile {
	private final int SIZE = 32;

	private boolean isWet;
	private boolean isVisible;
	private boolean isWalkable;
	private TileTypes type;
	private Image sprite;
	private String spritepath;

	public MapTile(boolean isWet, boolean isVisible, boolean isWalkable, TileTypes type, String texture) {
		this.isWet = isWet;
		this.isVisible = isVisible;
		this.type = type;
		this.isWalkable = isWalkable;

		String image = "src/src/Assets/Tiles/" + texture;
		String wet = "src/src/Assets/Tiles/Wet/" + texture;
		String black = "src/src/Assets/Tiles/Wet/Unrevealed.png";
		String unknown = "src/src/Assets/Tiles/MissingTexture.png";

		Path img = Paths.get(image).toAbsolutePath();
		Path wetimg = Paths.get(wet).toAbsolutePath();
		Path blackimg = Paths.get(black).toAbsolutePath();
		Path missing = Paths.get(unknown).toAbsolutePath();

		if (Files.exists(img)) {
			this.sprite = new ImageIcon(String.valueOf(blackimg)).getImage();
			this.spritepath = String.valueOf(img);
		} else {
			this.sprite = new ImageIcon(String.valueOf(missing)).getImage();
			this.spritepath = String.valueOf(missing);
		}

		System.out.println(spritepath);
	}

	public boolean isWet() {
		return isWet;
	}

	//TODO rework
	public void setWet(boolean wet) {
		this.isWet = wet;
		String temp = spritepath.replace("/", "\\");
		String asd = temp.replace("\\", "\\\\");
		ArrayList<String> path = new ArrayList<>(Arrays.asList(asd.split("\\\\")));

		path.removeIf(s -> s.equals(""));

		if (isWet && !path.contains("Wet")) {
			path.add(path.size() - 1, "Wet");
			StringBuilder sb = new StringBuilder();
			for (String s : path) {
				sb.append("\\").append(s);
			}
			this.spritepath = sb.substring(1);
		} else {
			path.remove(path.size() - 2);
			StringBuilder sb = new StringBuilder();
			for (String s : path) {
				sb.append("\\").append(s);
			}
			this.spritepath = sb.substring(1);
		}
		this.sprite = new ImageIcon(String.valueOf(this.spritepath)).getImage();
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean visible) {
		isVisible = visible;
	}

	public TileTypes getType() {
		return type;
	}

	public void setType(TileTypes type) {
		this.type = type;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public boolean isWalkable() {
		return isWalkable;
	}

	public String getSpritepath() {
		return spritepath;
	}

	public void setSpritepath(String spritepath) {
		this.spritepath = spritepath;
	}

	public void setWalkable(boolean walkable) {
		isWalkable = walkable;
	}
}
