package src;

import src.InventoryManagement.Inventory;
import src.NPC.Crew;

public class Player {
	private static int energy = 100;
	private static Inventory inv;
	private static Crew[] crew;
	private static int fow = 8;

	public Player() {
		energy = 100;
	}

	public void rest() {
		energy = 100;
	}
}
