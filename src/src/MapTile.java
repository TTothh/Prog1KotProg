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
	private boolean isWalkable = true;
	private TileTypes type;
	private Image sprite;
	private String spritepath;

	public MapTile() {
		this.isWet = true;
		this.isVisible = false;
		this.type = TileTypes.SEA;
		this.isWalkable = false;

		if (Files.exists(Paths.get("src/src/Assets/Tiles/Sea.png"))) {
			this.sprite = new ImageIcon("src/src/Assets/Tiles/Sea.png").getImage();
		} else {
			this.sprite = new ImageIcon("src/src/Assets/Tiles/MissingTexture.png").getImage();
		}
	}

	public MapTile(boolean isWet, boolean isVisible, boolean isWalkable, TileTypes type, String texture) {
		this.isWet = isWet;
		this.isVisible = isVisible;
		this.type = type;
		this.isWalkable = isWalkable;

		String image = "src/src/Assets/Tiles/" + texture;
		String wet = "src/src/Assets/Tiles/Wet/" + texture;
		String unknown = "src/src/Assets/Tiles/MissingTexture.png";

		Path img = Paths.get(image).toAbsolutePath();
		Path wetimg = Paths.get(wet).toAbsolutePath();
		Path missing = Paths.get(unknown).toAbsolutePath();

		if (Files.exists(img)) {
			this.sprite = new ImageIcon(String.valueOf(img)).getImage();
			this.spritepath = String.valueOf(img);
		} else {
			this.sprite = new ImageIcon(String.valueOf(missing)).getImage();
			this.spritepath = String.valueOf(missing);
		}
	}

	public boolean isWet() {
		return isWet;
	}

	public void setWet(boolean wet) {
		String asd = spritepath.replace("\\", "\\\\");
		ArrayList<String> path = new ArrayList<>(Arrays.asList(asd.split("\\\\")));

		path.removeIf(s -> s.equals(""));

		if (wet) {
			path.add(path.size() - 1, "wet");
			StringBuilder sb = new StringBuilder();
			for (String s : path) {
				sb.append("/").append(s);
			}
			this.spritepath = sb.substring(1);
			this.sprite = new ImageIcon(String.valueOf(sb)).getImage();
		} else {
			path.remove(path.size() - 2);
			StringBuilder sb = new StringBuilder();
			for (String s : path) {
				sb.append("/").append(s);
			}
			this.spritepath = sb.substring(1);
			this.sprite = new ImageIcon(String.valueOf(sb)).getImage();
		}
		isWet = wet;
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

	public void setWalkable(boolean walkable) {
		isWalkable = walkable;
	}
}
