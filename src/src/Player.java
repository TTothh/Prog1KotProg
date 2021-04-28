package src;

import src.InventoryManagement.Inventory;
import src.NPC.Crew;

import javax.swing.*;
import java.awt.*;

public class Player {
	private static int money = 300;
	private static int energy = 100;
	private static int maxInvSize = 8;
	private static Inventory inv;
	private static Crew crew;
	private static int fow = 2;
	private static Point position;
	private static Image sprite = new ImageIcon("src/src/Assets/Player/player.png").getImage();

	public Player() {
		energy = 100;
	}

	public void rest() {
		energy = 100;
	}

	public static Point getPosition() {
		return position;
	}

	public static void setPosition(Point position) {
		Player.position = position;
	}

	public static int getEnergy() {
		return energy;
	}

	public static void setEnergy(int energy) {
		Player.energy = energy;
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
}
