package src.GUI.Screen;

import src.Player;

import javax.swing.*;

public class Inventory extends JPanel {
	JLabel slot;
	JLabel item;

	/**
	 * kirajzolja az inventoryscreent.
	 * nem volt költségvetés az implementációra
	 */
	public Inventory() {
		slot = new JLabel();
		slot.setSize(32,32);

		for (int i = 0; i < Player.getInv().getSize(); i++) {
			//TODO
		}
	}
}
