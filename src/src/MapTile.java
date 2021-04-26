package src;

import src.Enums.TileTypes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

public class MapTile {
	private final int SIZE = 32;

	private boolean isWet;
	private boolean isVisible;
	private boolean isWalkable = true;
	private TileTypes type;
	private Image sprite;

	public MapTile() {
		this.isWet = true;
		this.isVisible = false;
		this.type = TileTypes.SEA;
		this.isWalkable = false;
		if(Files.exists(Paths.get("src/src/Assets/Tiles/Sea.png"))) {
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
		String unknown = "src/src/Assets/Tiles/MissingTexture.png";

		Path img = Paths.get(image).toAbsolutePath();
		Path missing = Paths.get(unknown).toAbsolutePath();

		if(Files.exists(img)) {
			this.sprite = new ImageIcon(String.valueOf(img)).getImage();
		} else {
			this.sprite = new ImageIcon((Image) missing).getImage();
		}
	}

	public boolean isWet() {
		return isWet;
	}

	public void setWet(boolean wet) {
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
}
