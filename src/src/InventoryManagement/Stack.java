package src.InventoryManagement;

import src.Enums.Items;
import src.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Stack {
	private List<Item> stack;
	private Items type;

	public Stack(Items type) {
		this.stack = new ArrayList<>(7);
		this.type = type;
	}

	public void addItem(int amount) {
		if(stack.size() <= 7) {
			for (int i = 0; i < amount; i++) {
				stack.add(new Item(type));
			}
		}
	}

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

	public void setType(Items type) {
		this.type = type;
	}
}
