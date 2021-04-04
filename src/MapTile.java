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
	private boolean isWet = false;
	private boolean isVisible = false;
	private final int SIZE = 32;
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
}
