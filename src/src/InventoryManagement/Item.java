package src.InventoryManagement;

import src.Enums.Items;

import javax.swing.*;

public class Item {
	private String name;
	private int price;
	private int energy;
	private boolean isAddictive;
	private Items type;
	private ImageIcon sprite;

	/**
	 * Az item osztály. Ők tárolódnak a stack-ekben
	 * @param item
	 */
	public Item(Items item) {
		this.type = item;
		this.name = (String) Items.getItem(item).get(0);
		this.price = (Integer) Items.getItem(item).get(1);
		this.energy = (Integer) Items.getItem(item).get(2);
		this.isAddictive = (boolean) Items.getItem(item).get(3);
		this.sprite = (ImageIcon) Items.getItem((item)).get(4);
	}

	public String getName() {
		return name;
	}

	public Items getType() {
		return type;
	}
}
