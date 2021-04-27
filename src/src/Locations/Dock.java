package src.Locations;

import src.Enums.Names;
import src.InventoryManagement.Inventory;
import src.NPC.Crew;
import src.NPC.NPC;

import java.awt.*;

public class Dock {
	private static Point position;
	private Inventory inventory = new Inventory(8);;
	private Crew crew = new Crew(3);

	public Dock(Point position) {
		Dock.position = position;
	}

	private void fillCrew() {
		crew.addCrewMember(new NPC(src.Enums.NPC.SHAMAN, Names.randomName()));
	}

	public static Point getPosition() {
		return position;
	}
}
