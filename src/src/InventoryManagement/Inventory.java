package src.InventoryManagement;

import src.Enums.Items;
import src.Items.Item;
import src.JavaReImplementations.Random;

import java.util.Arrays;
import java.util.HashMap;

public class Inventory {
	private int size = 0;
	Stack[] inventory;
	HashMap<Items, Integer> amounts = new HashMap<>();

	public Inventory(int size) {
		this.size = size;
		inventory = new Stack[this.size];
		for (int i = 0; i < inventory.length; i++) {
			inventory[i] = new Stack(Items.Empty);
		}
		update();
	}

	public void addSize(int size) {
		Stack[] temp = inventory;
		inventory = Arrays.copyOf(temp, size);
		update();
	}

	public void shrink(int size) {
		Stack[] temp = inventory;
		Stack[] newInv = new Stack[size];

		System.arraycopy(temp, 0, newInv, 0, newInv.length);

		inventory = newInv;
		update();
	}

	public void update() {
		for (Stack stack : inventory) {
			amounts.put(stack.getType(), stack.getSize());
		}
	}

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

	public void addItem(Item item, int amount) {
		int remaining = amount;

		if (canAdd(item, amount)) {
			for (Stack stack : inventory) {
				if(remaining > 0) {
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

	//I don't need this. Theoretically
	public boolean hasEmpty() {
		for (Stack stack : inventory) {
			if (stack.getType() == Items.Empty) {
				return true;
			}
		}

		return false;
	}

	public void removeItem(Stack stack, int amount) {
		stack.removeItem(amount);

		update();
	}

	public int getSize() {
		return size;
	}
}
