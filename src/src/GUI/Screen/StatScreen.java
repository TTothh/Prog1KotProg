package src.GUI.Screen;

import src.GUI.ClickedListener;
import src.Player;

import javax.swing.*;
import java.awt.*;

/**
 * A játékablak alján látható részt írja ki
 */
public class StatScreen extends JPanel {
	static EnergyBar bar = new EnergyBar();
	static PlayerStats ps = new PlayerStats();
	static Inventory inv = new Inventory();

	public StatScreen() {
		setBounds(0, 30 * 32 + 1, 50 * 32, 100);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		add(bar);
		add(ps);
		add(inv);
	}

	/**
	 * frissíti a játékos életét  a progressbaron
	 *
	 */

	public static void update() {
		bar.setValue((int) Player.getEnergy());
		bar.setString(String.valueOf(bar.getValue()));
		ps.setText("<html>Crew size: " + Player.getCrew().getSize() + "<br>Invsize: " + Player.getMaxInvSize() + "</html>");
		inv.init();

	}

	/**
	 * A játékos életét ábrázoló progressbar
	 *
	 */

	static class EnergyBar extends JProgressBar {
		public EnergyBar() {
			setOrientation(HORIZONTAL);
			setBounds(10, 10, 100, 30);
			setValue((int) Player.getEnergy());
			setStringPainted(true);
			setString(String.valueOf(getValue()));
		}
	}

	static class PlayerStats extends JLabel {
		public PlayerStats() {
			setBounds(150, 10, 200, 30);
		}
	}

	/**
	 * A játéktér alján lévő játékos inventory
	 */
	static class Inventory extends JPanel {
		public Inventory() {
			init();
		}

		public void init() {
			removeAll();

			setLayout(new GridLayout());
			setBounds(300, 5, 500, 40);

			for (int i = 0; i < Player.getInv().getSize(); i++) {
				add(new InvSlot(i));
			}
		}

		/**
		 * Egy darab inventory slot. klikkelésnél a játékos használja az itemet; már ha tudja. Ha nem akkor csak elveszik. Minek gyújtasz fáklyát nappal???
		 *
		 */

		class InvSlot extends JLabel {
			int index = 0;

			public InvSlot(int index) {
				this.index = index;
				setSize(32, 32);
				try {
					setIcon((ImageIcon) Player.getInv().getSlot(index).getType().getItem(Player.getInv().getSlot(index).getType()).get(4));
					setText(String.valueOf(Player.getInv().getSlot(index).getSize()));
					addMouseListener((ClickedListener) e -> {
						Player.useItem(index);
						setText(String.valueOf(Player.getInv().getSlot(index).getSize()));
						repaint();
					});
				} catch (Exception ignored) {
				}
			}
		}
	}
}
