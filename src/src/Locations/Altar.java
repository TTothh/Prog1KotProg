package src.Locations;

import src.InventoryManagement.Inventory;

import java.awt.*;

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
