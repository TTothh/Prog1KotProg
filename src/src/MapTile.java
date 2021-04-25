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

	public Image drawMaptile(TileTypes type) throws IOException {
		//BufferedImage tile = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_4BYTE_ABGR);
		BufferedImage tile;
		try {
			tile = ImageIO.read(new File(("src/Assets/Tiles/" + type + ".png")));
		} catch (IOException e) {
			tile = ImageIO.read(new File(("src/Assets/Tiles/MissingTexture.png")));
			Logging.Log(type + ".png not found", "Logs/mainLog.log", Class.class.getName(), Level.WARNING);
		}

		return tile;
	}

	public MapTile() {
		this.isWet = true;
		this.isVisible = false;
		this.type = TileTypes.SEA;
		this.isWalkable = false;
		if(Files.exists(Paths.get("src/Assets/Tiles/Sea.png"))) {
			this.sprite = new ImageIcon("src/Assets/Tiles/Sea.png").getImage();
		} else {
			this.sprite = new ImageIcon("src/Assets/Tiles/MissingTexture.png").getImage();
		}
	}

	public MapTile(boolean isWet, boolean isVisible, boolean isWalkable, TileTypes type, String texture) {
		this.isWet = isWet;
		this.isVisible = isVisible;
		this.type = type;
		this.isWalkable = isWalkable;
		String image = "src/Assets/Tiles/" + texture;

		if(Files.exists(Paths.get(image))) {
			this.sprite = new ImageIcon(image).getImage();
		} else {
			this.sprite = new ImageIcon("src/Assets/Tiles/MissingTexture.png").getImage();
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
}
