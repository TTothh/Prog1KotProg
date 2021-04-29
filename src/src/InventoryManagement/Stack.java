package src.InventoryManagement;

import src.Enums.Items;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Az inventory elemi része. itt tárolódnak az itemek
 */
public class Stack {
	private List<Item> stack;
	private Items type;
	private Image sprite;

	public Stack(Items type) {
		this.stack = new ArrayList<>(7);
		this.type = type;
	}

	/**
	 * hozzáad item-et a stackhez ha befér
	 * @param amount
	 */
	public void addItem(int amount) {
		if(stack.size() <= 7) {
			for (int i = 0; i < amount; i++) {
				stack.add(new Item(type));
			}
		}
	}

	/**
	 * kivesz amount-nyi item-et a stackből ha ki tud annyit venni
	 * @param amount
	 */
	public void removeItem(int amount) {
		if(stack.size() >= amount) {
			IntStream.range(0, amount).forEach(i -> stack.remove(i));
		}
		if(stack.size() == 0) {
			this.type = Items.Empty;
		}
	}

	public boolean canAddItem() {
		return 7 > stack.size();
	}

	/**
	 * visszatér hogy mennyit lehet még a stack-hez adni
	 * @return
	 */
	public int amountCanBeAdded() {
		return 7 - stack.size();
	}
	public int getSize() {
		return stack.size();
	}

	public List<Item> getStack() {
		return stack;
	}

	public Items getType() {
		return type;
	}

	public Item getItem() {
		return stack.get(0);
	}

	public void setType(Items type) {
		this.type = type;
	}
}
