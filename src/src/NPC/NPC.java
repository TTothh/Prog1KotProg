package src.NPC;

import src.InventoryManagement.Stack;
import src.Items.Item;
import src.JavaReImplementations.Random;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class NPC {
	private int price = 150;
	private String name;
	private boolean isAddicted = false;
	private Item addiction;
	private src.Enums.NPC type;
	private Item[] consumed = new Item[2];
	private UUID uuid;
	private boolean isHurt = false;
	private Image sprite;

	public NPC(src.Enums.NPC type, String name) {
		this.type = type;
		this.name = name;
		uuid = UUID.randomUUID();

		if(Files.exists(Path.of("src/src/Assets/Player/" + type + ".png"))) {
			sprite = new ImageIcon("src/src/Assets/Player/" + type + ".png").getImage();
		} else {
			sprite = new ImageIcon("src/src/Assets/Tiles/MissingTexture.png").getImage();
		}
	}

	public boolean leave() {
		Random r = new Random();
		int chance = r.NextRandom(0, 100);
		return chance <= 5;
	}

	public void consume(Stack stack, Item item) {
		stack.removeItem(1);
		consumed[1] = consumed[0];
		consumed[0] = item;
	}

	public void getHurt() {
		this.isHurt = true;
	}

	public boolean isHurt() {
		return this.isHurt;
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

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setHurt(boolean hurt) {
		isHurt = hurt;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
}
