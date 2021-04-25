package src.Locations;

import src.Enums.Items;
import src.Enums.Names;
import src.InventoryManagement.Inventory;
import src.Items.Item;
import src.JavaReImplementations.Random;
import src.NPC.Crew;
import src.NPC.NPC;

public class Village {
	private int relation = 2;
	private Inventory inv;
	private Crew crew;

	public Village(int relation, Crew crew) {
		this.relation = relation;
		this.inv = new Inventory(8);
		this.crew = crew;

		fillCrew();
		fillInv();
	}

	private void fillCrew() {
		crew.addCrewMember(new NPC(src.Enums.NPC.SHAMAN, Names.randomName()));
	}

	private void fillInv() {
		Random r = new Random();
		int amountOfItems = new Random().NextRandom(0, 6);
		int[] counts = new int[amountOfItems];
		Item item;

		for (int i = 0; i < counts.length; i++) {
			counts[i] = r.NextRandom(0, 6);
			item = new Item(Items.getRandom());
			inv.addItem(item, counts[i]);
		}
	}

	public int getRelation() {
		return relation;
	}

	public Inventory getInv() {
		return inv;
	}

	public Crew getCrew() {
		return crew;
	}
}
