package src.Enums;

import src.Logging;

import javax.swing.*;
import java.util.*;
import java.util.logging.Level;


/**
 * Enum az Itemekhez
 */
public enum Items {
	Empty("Default", 0, 0, false, new ImageIcon("src/src/Assets/Items/Empty.png")),
	Chocolate("Chocolate", 15, 20, false, new ImageIcon("src/src/Assets/Items/Chocholate.png")),
	Drug("Drug", 40, 20, true, new ImageIcon("src/src/Assets/Items/Drug.png")),
	Fruit("Fruit", 20, 15, false, new ImageIcon("src/src/Assets/Items/Fruit.png")),
	Glassball("Glassball", 30, 0, false, new ImageIcon("src/src/Assets/Items/Glassball.png")),
	Machete("Machete", 15, 0, false, new ImageIcon("src/src/Assets/Items/Machete.png")),
	Meat("Meat", 15, 25, false, new ImageIcon("src/src/Assets/Items/Meat.png")),
	Rope("Rope", 8, 0, false, new ImageIcon("src/src/Assets/Items/Rope.png")),
	Torch("Torch", 20, 0, false, new ImageIcon("src/src/Assets/Items/Torch.png")),
	Whisky("Whisky", 20, 20, true, new ImageIcon("src/src/Assets/Items/Alcohol.png"));

	private static final Map<String, Items> itemName = new HashMap<>();
	private static final Map<Integer, Items> itemPrice = new HashMap<>();
	private static final Map<Integer, Items> itemEnergy = new HashMap<>();
	private static final Map<Boolean, Items> itemIsAddictive = new HashMap<>();
	private static final Map<ImageIcon, Items> sprites = new HashMap<>();

	private static final List<Items> VALUES = List.of(values());
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();


	/**
	 * ez lefut "magától" és hozzáadja a dolgokat a HashMap-ekhez hogy később lekérdezhetőek legyenek
	 */

	static {
		for (Items i : values()) {
			itemName.put(i.name, i);
			itemPrice.put(i.price, i);
			itemEnergy.put(i.energy, i);
			itemIsAddictive.put(i.isAddictive, i);
			sprites.put(i.sprite, i);
		}
	}

	private final String name;
	private final int price;
	private final int energy;
	private final boolean isAddictive;
	private final ImageIcon sprite;

	/**
	 * Kontruktor
	 * @param name
	 * @param price
	 * @param energy
	 * @param isAddictive
	 * @param sprite
	 */
	Items(String name, int price, int energy, boolean isAddictive, ImageIcon sprite) {
		this.name = name;
		this.price = price;
		this.energy = energy;
		this.isAddictive = isAddictive;
		this.sprite = sprite;
	}

	/**
	 * Item lekérdezése. egy Object típusú listát ad vissza amit "helyben" kell parse-olni
	 * @param item
	 * @return List<Object>
	 */

	public static List<Object> getItem(Items item) {
		List<Object> results = new ArrayList<>();
		try {
			results.add(item.name);
			results.add(item.price);
			results.add(item.energy);
			results.add(item.isAddictive);
			results.add(item.sprite);
		} catch (Exception e ) {
			System.out.println("Wrong item");
			Logging.Log("Wrong item: " + item, "Setup.log", "Items", Level.SEVERE);
		}

		return results;
	}

	/**
	 * Egy random item-mel tér vissza
	 * @return
	 */

	public static Items getRandom()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
