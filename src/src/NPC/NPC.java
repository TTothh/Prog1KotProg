package src.NPC;

import src.Enums.Items;
import src.InventoryManagement.Stack;
import src.Items.Item;

import java.util.UUID;

public class NPC {
	private int price = 150;
	private String name;
	private boolean isAddicted = false;
	private Item addiction;
	private src.Enums.NPC type;
	private Item[] consumed = new Item[2];
	private UUID uuid = UUID.randomUUID();

	public NPC(src.Enums.NPC type, String name) {
		this.type = type;
		this.name = name;
	}

	public void consume(Stack stack, Item item) {
		stack.removeItem(1);
		consumed[1] = consumed[0];
		consumed[0] = item;
	}

	public void becomeAddicted() {
		this.isAddicted = true;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAddicted() {
		return isAddicted;
	}

	public void setAddicted(boolean addicted) {
		isAddicted = addicted;
	}

	public Item getAddiction() {
		return addiction;
	}

	public void setAddiction(Item addiction) {
		this.addiction = addiction;
	}

	public src.Enums.NPC getType() {
		return type;
	}

	public void setType(src.Enums.NPC type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public UUID getUuid() {
		return uuid;
	}
}
