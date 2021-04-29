package src.NPC;

import src.InventoryManagement.Stack;
import src.InventoryManagement.Item;
import src.JavaReImplementations.Random;
import src.Player;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * Npc osztály. Ezekből áll egy Crew
 */
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
	private int addictionTime;

	/**
	 * Kontruktor
	 * @param type
	 * @param name
	 */
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

	/**
	 * Ha függő az NPC és már több mint 30 kör telt el akkor ki próbál majd lépni a csapatból.
	 * @return Boolean. máshol veszem ki a Crew-ból
	 */
	public boolean tryLeave() {
		if(isAddicted && addictionTime >= 30) {
			Random r = new Random();
			int chance = r.NextRandom(0, 100);
			return chance <= 10;
		}

		return false;
	}

	/**
	 * HA a játékosnak nincs energiája akkor 8% eséllyel hagyja el a csapatot.
	 * @return Boolean
	 */
	public boolean depart() {
		if(Player.getEnergy() <= 0) {
			Random r = new Random();
			int chance = r.NextRandom(0, 100);
			return chance <= 8;
		}

		return false;
	}

	/**
	 * Az utolsó két fogyasztott item-et tartja számom a függőségek révett.
	 * @param stack
	 * @param item
	 */

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

	/**
	 * Ha az utolsó két item ugyanaz és addicitve-ak akkor 15% esélllyel válik üfggővé az NPC
	 *
	 */
	public void becomeAddicted() {
		if(!isAddicted) {
			if (consumed[0].getName().equals(consumed[1].getName())) {
				Random r = new Random();
				int chance = r.NextRandom(0, 100);

				if (chance <= 15) {
					isAddicted = true;
					addiction = consumed[0];
					System.out.println("Addicted");
				}
			}
		}
	}

	//Getterek setterek. van egy pár.

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

	public int getAddictionTime() {
		return addictionTime;
	}

	public void setAddictionTime(int addictionTime) {
		this.addictionTime = addictionTime;
	}
}
