package src.Locations;

import src.InventoryManagement.Inventory;

public class Altar {
	private Inventory inv;

	public Altar() {
		this.inv = new Inventory(8);
		inv.fillInv();
	}

	public Inventory getInv() {
		return inv;
	}
}
