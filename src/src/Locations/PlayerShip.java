package src.Locations;

import src.InventoryManagement.Inventory;

import java.awt.*;

public class PlayerShip {
	private static Point position;
	private static Inventory inv = new Inventory(10000);

	public PlayerShip(Point position) {
		PlayerShip.position = position;
	}

	public static Point getPosition() {
		return position;
	}

	public Inventory getInv() {
		return inv;
	}
}
