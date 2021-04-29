package src.InventoryManagement;

import src.Enums.Items;
import src.JavaReImplementations.Random;

import java.util.Arrays;
import java.util.HashMap;

/**
 * A játékos inventory-ja valamint annak a managelése
 */

public class Inventory {
	private int size;
	Stack[] inventory;
	HashMap<Items, Integer> amounts = new HashMap<>();

	/**
	 * Kontruktor. új inventry inicializál a megadott méretben
	 *
	 * @param size
	 */
	public Inventory(int size) {
		this.size = size;
		inventory = new Stack[this.size];
		for (int i = 0; i < inventory.length; i++) {
			inventory[i] = new Stack(Items.Empty);
		}
		update();
	}

	public Stack getSlot(int index) {
		return inventory[index];
	}

	/**
	 * Megnöveli az inventory méretét a kapott értékkel
	 *
	 * @param size
	 */

	public void addSize(int size) {
		Stack[] temp = inventory;
		inventory = Arrays.copyOf(temp, size);
		update();
	}

	/**
	 * lecsökkenti az inventory méretét az adott értékkel
	 *
	 * @param size
	 */
	public void shrink(int size) {
		Stack[] temp = inventory;
		Stack[] newInv = new Stack[size];

		System.arraycopy(temp, 0, newInv, 0, newInv.length);

		inventory = newInv;
		update();
	}

	/**
	 * Az amounts Hashmap-etz tölti fel az inventory-ban levő dolgokkal. számon tartja milyen item-ből mennyink van
	 */

	public void update() {
		for (Stack stack : inventory) {
			amounts.put(stack.getType(), stack.getSize());
		}
	}

	public boolean hasItem(Items item) {
		for (Stack stack : inventory) {
			if (stack.getType() == item) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Visszaadja hogy van-e elég hely az inventory-ban a megadott item-nek
	 *
	 * @param item
	 * @param amount
	 * @return
	 */

	//returns if we have enough space in this inventory across stacks for the item
	private boolean canAdd(Item item, int amount) {
		int freespace = 0;
		for (Stack stack : inventory) {
			if (freespace >= amount) {
				return true;
			}

			if (stack.getSize() == 0 || stack.getType() == Items.Empty) {
				freespace += 7;
				continue;
			}

			if (stack.getType() == item.getType()) {
				freespace += 7 - stack.getSize();
			}
		}

		return false;
	}

	/**
	 * Inventory-hoz ad, elosztja a stack-ek között a dolgokat
	 *
	 * @param item
	 * @param amount
	 */
	public void addItem(Item item, int amount) {
		int remaining = amount;

		if (canAdd(item, amount)) {
			for (Stack stack : inventory) {
				if (remaining > 0) {
					if (stack.getType() == item.getType() || (stack.getType() == Items.Empty)) {
						if (stack.getType() == Items.Empty) {
							stack.setType(item.getType());
						}
						int deduct = Math.min(stack.amountCanBeAdded(), remaining);
						stack.addItem(deduct);
						remaining -= deduct;
					}
				} else {
					break;
				}
			}
		} else {
			System.out.println("Not enough space in inventory");
		}
		update();
	}

	/**
	 * random item-ekkel tölti fel az inventory-t
	 */
	public void fillInv() {
		Random r = new Random();
		int amountOfItems = new Random().NextRandom(1, 6);
		int[] counts = new int[amountOfItems];
		Item item;

		for (int i = 0; i < counts.length; i++) {
			counts[i] = r.NextRandom(0, 6);
			item = new Item(Items.getRandom());
			addItem(item, counts[i]);
		}

		update();
	}

	/**
	 * ellenőrzi hogy van-e üres hely az inventory-ban. A szofisztikált design végetet viszont ez az eljárás nincs használatban
	 *
	 * @return
	 */
	//I don't need this. Theoretically
	public boolean hasEmpty() {
		for (Stack stack : inventory) {
			if (stack.getType() == Items.Empty) {
				return true;
			}
		}
		return false;
	}

	/**
	 * A megadott stack-ből vesz ki Item-et
	 *
	 * @param item
	 * @param amount
	 */
	public void removeItem(Items item, int amount) {
		for (Stack stack : inventory) {
			if (stack.getType() == item) {
				stack.removeItem(amount);
			}
		}

		update();
	}

	public int getSize() {
		return size;
	}
}
