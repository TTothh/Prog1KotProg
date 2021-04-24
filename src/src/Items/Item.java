package src.Items;

import src.Enums.Items;

public class Item {
	private String name;
	private int price;
	private int energy;
	private boolean isAddictive;
	private Items type;

	public Item(Items item) {
		this.type = item;
		this.name = (String) item.getItem(item).get(0);
		this.price = (Integer) item.getItem(item).get(1);
		this.energy = (Integer) item.getItem(item).get(2);
		this.isAddictive = (boolean) item.getItem(item).get(3);
	}

	public int getPrice() {
		return price;
	}

	public int getEnergy() {
		return energy;
	}

	public boolean isAddictive() {
		return isAddictive;
	}
}
