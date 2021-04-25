package src.NPC;

import java.util.ArrayList;
import java.util.UUID;

public class Crew {
	private int size;
	private ArrayList<NPC> Crew;

	public Crew(int size) {
		this.size = size;
		Crew = new ArrayList<>(size);
	}

	public void addCrewMember(NPC member) {
		if (Crew.size() < size) {
			Crew.add(member);
		}
	}

	public void removeCrewMember(UUID uuid) {
		Crew.removeIf(npc -> npc.getUuid() == uuid);
	}
}
