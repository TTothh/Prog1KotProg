package src.Locations;

import src.Enums.Names;
import src.InventoryManagement.Inventory;
import src.NPC.Crew;
import src.NPC.NPC;

import java.awt.*;

public class Village {
	private int relation = 2;
	private Inventory inv;
	private Crew crew;

	public Village(int relation) {
		this.relation = relation;
		this.inv = new Inventory(8);
		crew = new Crew(3);

		fillCrew();
		inv.fillInv();
	}

	private void fillCrew() {
		crew.addCrewMember(new NPC(src.Enums.NPC.SHAMAN, Names.randomName()));
		crew.addCrewMember(new NPC(src.Enums.NPC.SCOUT, Names.randomName()));
		crew.addCrewMember(new NPC(src.Enums.NPC.SAGE, Names.randomName()));
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
