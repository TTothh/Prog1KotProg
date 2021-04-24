package src.Enums;

import src.Logging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public enum Items {
	Chocolate("Chocolate", 15, 20, false),
	Drug("Drug", 40, 20, true),
	Fruit("Fruit", 20, 15, false),
	Glassball("Glassball", 30, 0, false),
	Machete("Machete", 15, 0, false),
	Meat("Meat", 15, 25, false),
	Rope("Rope", 8, 0, false),
	Torch("Torch", 20, 0, false),
	Whisky("Whisky", 20, 20, true);

	private static final Map<String, Items> itemName = new HashMap<>();
	private static final Map<Integer, Items> itemPrice = new HashMap<>();
	private static final Map<Integer, Items> itemEnergy = new HashMap<>();
	private static final Map<Boolean, Items> itemIsAddictive = new HashMap<>();

	static {
		for (Items i : values()) {
			itemName.put(i.name, i);
			itemPrice.put(i.price, i);
			itemEnergy.put(i.energy, i);
			itemIsAddictive.put(i.isAddictive, i);
		}
	}

	private final String name;
	private final int price;
	private final int energy;
	private final boolean isAddictive;

	Items(String name, int price, int energy, boolean isAddictive) {
		this.name = name;
		this.price = price;
		this.energy = energy;
		this.isAddictive = isAddictive;
	}

	public List<Object> getItem(Items item) {
		List<Object> results = new ArrayList<>();
		try {
			results.add(item.name);
			results.add(item.price);
			results.add(item.energy);
			results.add(item.isAddictive);
		} catch (Exception e ) {
			System.out.println("Wrong item");
			Logging.Log("Wrong item: " + item, "Setup.log", this.getClass().getName(), Level.SEVERE);
		}

		return results;
	}

	/*public static Items getName(String name) {
		Items result = itemName.get(name);
		if (result == null) {
			throw new IllegalArgumentException("Invalid category name: " + name);
		}
		return result;
	}

	public static Items getPrice(int price) {
		Items result = itemName.get(price);
		if (result == null) {
			throw new IllegalArgumentException("Invalid category name: " + price);
		}
		return result;
	}

	public static Items getEnergy(int energy) {
		Items result = itemName.get(energy);
		if (result == null) {
			throw new IllegalArgumentException("Invalid category name: " + energy);
		}
		return result;
	}

	public static Items isAddictive(String isAddictive) {
		Items result = itemName.get(isAddictive);
		if (result == null) {
			throw new IllegalArgumentException("Invalid category name: " + isAddictive);
		}
		return result;
	}*/
}
