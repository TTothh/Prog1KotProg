package src.Locations;

import src.InventoryManagement.Inventory;

public class PlayerShip {
	private static Inventory inv = new Inventory(10000);

	public Inventory getInv() {
		return inv;
	}
}
