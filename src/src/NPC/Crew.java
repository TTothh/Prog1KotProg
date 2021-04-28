package src.NPC;

import java.util.ArrayList;
import java.util.UUID;

public class Crew {
	private int maxSize;
	private ArrayList<NPC> Crew;

	public Crew(int size) {
		this.maxSize = size;
		Crew = new ArrayList<>(0);
	}

	public void addCrewMember(NPC member) {
		if (Crew.size() < maxSize) {
			Crew.add(member);
		}
	}

	public NPC getCrewMember(int index) {
		return Crew.get(index);
	}

	public boolean canAdd() {
		return Crew.size() < maxSize;
	}

	public boolean canRemove() {
		return Crew.size() > 0;
	}

	public void removeCrewMember(UUID uuid) {
		Crew.removeIf(npc -> npc.getUuid() == uuid);
	}
}
