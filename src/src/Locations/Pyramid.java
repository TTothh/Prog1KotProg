package src.Locations;

import src.InventoryManagement.Inventory;

import java.awt.*;

public class Pyramid {
	private static Point position;
	private static Inventory inv;


	public Pyramid(Point position) {
		Pyramid.position = position;
	}

	public static Point getPosition() {
		return position;
	}

	public static Inventory getInv() {
		return inv;
	}
}
