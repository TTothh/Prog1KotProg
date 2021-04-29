package src;

import src.Enums.Items;
import src.Enums.NPC;
import src.InventoryManagement.Inventory;
import src.NPC.Crew;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * A játékos.
 */
public class Player {
	private static int money = 0;
	private static double energy = 100;
	private static int maxInvSize = 8;
	private static Inventory inv = new Inventory(8);
	private static Crew crew;
	private static int fow = 2;
	private static Point position;
	private static Image sprite = new ImageIcon("src/src/Assets/Player/player.png").getImage();
	private static boolean canMove = true;
	private static double movecost = 1;

	public Player() {
		energy = 100;
	}

	public void rest() {
		energy = 100;
	}

	/**
	 * Item használata. itt van lekezelve az addikció és az item használat. Fun fact: ez a leghossabb funkció a játékban
	 * @param index
	 */
	public static void useItem(int index) {
		List<Object> item = Player.getInv().getSlot(index).getType().getItem(Player.getInv().getSlot(index).getType());
		int itemPrice = (Integer) item.get(1);
		int itemEnergy = (Integer) item.get(2);
		boolean itemIsAddictive = (Boolean) item.get(3);
		ImageIcon sprite = (ImageIcon) item.get(4);

		if(Player.getCrew().hasCrewMember(NPC.SOLDIER) && Player.getInv().getSlot(index).getType() == Items.Whisky) {
			Player.addEnergy(itemEnergy * 1.20);
		} else if(Player.getCrew().hasCrewMember(NPC.SHAMAN) && Player.getInv().getSlot(index).getType() == Items.Drug) {
			Player.addEnergy(itemEnergy * 1.20);
		} else {
			Player.addEnergy(itemEnergy);
		}

		for (int i = 0; i < Player.getCrew().getSize(); i++) {
			Player.getCrew().getCrewMember(i).consume(Player.getInv().getSlot(index), Player.getInv().getSlot(index).getItem());
		}

		if(itemIsAddictive) {
			for (int i = 0; i < Player.getCrew().getSize(); i++) {
				Player.getCrew().getCrewMember(i).becomeAddicted();
				if(Player.getCrew().getCrewMember(i).tryLeave()) {
					Player.getCrew().removeCrewMember(Player.getCrew().getCrewMember(i).getUuid());
				}
			}
		}
	}

	public static Point getPosition() {
		return position;
	}

	public static void setPosition(Point position) {
		Player.position = position;
	}

	public static double getEnergy() {
		return energy;
	}

	public static void setEnergy(double energy) {
		Player.energy = energy;
	}

	public static void addEnergy(double energy) {
		Player.energy += energy;
	}

	public static Inventory getInv() {
		return inv;
	}

	public static void setInv(Inventory inv) {
		Player.inv = inv;
	}

	public static Crew getCrew() {
		return crew;
	}

	public static void setCrew(Crew crew) {
		Player.crew = crew;
	}

	public static int getFow() {
		return fow;
	}

	public static void setFow(int fow) {
		Player.fow = fow;
	}

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}

	public static int getMaxInvSize() {
		return maxInvSize;
	}

	public static void setMaxInvSize(int maxInvSize) {
		Player.maxInvSize = maxInvSize;
	}

	public static Image getSprite() {
		return sprite;
	}

	public static void setSprite(Image sprite) {
		Player.sprite = sprite;
	}

	public static boolean isCanMove() {
		return canMove;
	}

	public static void setCanMove(boolean canMove) {
		Player.canMove = canMove;
	}

	public static double getMovecost() {
		if(inv.getSize() > maxInvSize) {
			return movecost * (1 + ((inv.getSize() - maxInvSize) * 0.20));
		}

		return movecost;
	}

	public static void setMovecost(double movecost) {
		Player.movecost = movecost;
	}
}
