import Enums.TileTypes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapTile {
	private final int SIZE = 32;

	private boolean isWet = false;
	private boolean isVisible = false;
	private TileTypes type;

	public Image drawMaptile(TileTypes type) throws IOException {
		//BufferedImage tile = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_4BYTE_ABGR);
		BufferedImage tile;
		try {
			tile = ImageIO.read(new File(("Assets/Tiles/" + type + ".png")));
		} catch (IOException e) {
			tile = ImageIO.read(new File(("Assets/Tiles/MissingTexture.png")));
			Logging.Log(type + ".png not found", "Logs/mainLog.log", Class.class.getName(), Level.WARNING);
		}

		return tile;
	}

	public MapTile() {
		this.isWet = true;
		this.isVisible = false;
		this.type = TileTypes.SEA;
	}

	public MapTile(boolean isWet, boolean isVisible, TileTypes type) {
		this.isWet = isWet;
		this.isVisible = isVisible;
		this.type = type;
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