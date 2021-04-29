package src.NPC;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Egy csapat.
 */
public class Crew {
	private int maxSize;
	private ArrayList<NPC> Crew;

	public Crew(int size) {
		this.maxSize = size;
		Crew = new ArrayList<>(0);
	}

	/**
	 * hozzáad egy csapattársat a csapathoz ha nincs teli a csapat
	 * @param member
	 */
	public void addCrewMember(NPC member) {
		if (Crew.size() < maxSize) {
			Crew.add(member);
		}
	}

	public NPC getCrewMember(int index) {
		return Crew.get(index);
	}

	/**
	 * Megnézi hogy adott típusó NPC van-e a csapatban
	 * @param type
	 * @return
	 */
	public boolean hasCrewMember(src.Enums.NPC type) {
		for (int i = 0; i < Crew.size(); i++) {
			if(Crew.get(i).getType() == type) {
				return true;
			}
		}

		return false;
	}

	public int getSize() {
		return Crew.size();
	}

	public boolean canAdd() {
		return Crew.size() < maxSize;
	}

	public boolean canRemove() {
		return Crew.size() > 0;
	}

	/**
	 * UUID alapján eltávolítja a csapattársat és kiírja konsole-ra hogy elhagyta a team-et
	 * @param uuid
	 */
	public void removeCrewMember(UUID uuid) {
		for (NPC npc : Crew) {
			if(npc.getUuid() == uuid) {
				System.out.println(npc.getName() + " joined the other crew");
			}
		}
		Crew.removeIf(npc -> npc.getUuid() == uuid);
	}
}
