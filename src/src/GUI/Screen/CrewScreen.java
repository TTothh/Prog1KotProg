package src.GUI.Screen;

import src.Enums.Names;
import src.NPC.Crew;
import src.NPC.NPC;
import src.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Csapattárst felkínáló ablak
 */
public class CrewScreen extends JFrame {
	protected Crew localCrew;
	JPanel crew1 = new JPanel();
	JPanel crew2 = new JPanel();

	/**
	 * Kontruktor
	 * @param crew
	 */
	public CrewScreen(Crew crew, ArrayList<src.Enums.NPC> types) {
		localCrew = crew;
		localCrew.addCrewMember(new NPC(types.get(0), Names.randomName()));
		localCrew.addCrewMember(new NPC(types.get(1), Names.randomName()));
		localCrew.addCrewMember(new NPC(types.get(2), Names.randomName()));

		draw();

		setVisible(true);
		pack();
	}

	/**
	 * Setupolja a JFrame elemeit és kirajzolja illetva frissíti a layout-ot
	 *
	 */
	public void draw() {
		setUndecorated(true);
		setSize(500, 300);
		setBounds(30, 30, 500, 300);
		setName("CrewScreen");
		setLayout(new GridLayout());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		remove(crew1);
		remove(crew2);

		repaint();
		revalidate();

		crew1.setSize(100, 60);
		crew1.setLayout(new FlowLayout());
		crew1.setBounds(10, 10, 100, 60);
		crew1.setBackground(new Color(255, 0, 0, 0));

		for (int i = 0; i < localCrew.getSize(); i++) {
			crew1.add(new CrewSlot(false, i));
		}

		crew2.setSize(100, 60);
		crew2.setLayout(new FlowLayout());
		crew1.setBounds(10, 10, 100, 60);
		crew2.setBackground(new Color(0, 255, 0, 0));

		for (int i = 0; i < Player.getCrew().getSize(); i++) {
			crew2.add(new CrewSlot(true, i));
		}

		add(crew1);
		add(crew2);

		repaint();
		revalidate();
	}

	//TODO: Inventory background

	/**
	 * Jpanel amit a crewitem-ekkel töltök föl
	 *
	 */
	class CrewSlot extends JPanel {
		public CrewSlot(boolean isplayerCrew, int index) {
			if (Files.exists(Path.of("/src/src/Assets/GUI/InventorySlot.png"))) {
				//setIcon(new ImageIcon("/src/src/Assets/GUI/InventorySlot.png"));
				setBackground(Color.BLACK);
			}

			setSize(32, 32);
			setLayout(new GridLayout());

			if (isplayerCrew) {
				add(new CrewItem(true, Player.getCrew().getCrewMember(index).getSprite(), index));
			} else {
				add(new CrewItem(false, localCrew.getCrewMember(index).getSprite(), index));
			}

		}
	}

	/**
	*	Crewitem. Erre kattintva a jaátékos csapatához kerül egy új csapattárs akkor be is záródik az ablak.
	*
	 */

	class CrewItem extends JLabel implements MouseListener {
		int index;
		boolean isPlayerCrew;

		public CrewItem(boolean isplayerCrew, Image image, int index) {
			this.index = index;
			this.isPlayerCrew = isplayerCrew;

			setIcon(new ImageIcon(image));
			addMouseListener(this);
		}

		/**
		 * Lebonyolítja az új csapattárs hozzáadását a játékos csapatához
		 * @param e
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			if (!isPlayerCrew) {
				if (localCrew.canRemove() && Player.getCrew().canAdd()) {
					Player.getCrew().addCrewMember(localCrew.getCrewMember(index));

					if(localCrew.getCrewMember(index).getType() == src.Enums.NPC.DONKEY) {
						Player.setMaxInvSize(10);
					}

					if (localCrew.getCrewMember(index).getType() == src.Enums.NPC.SCOUT) {
						Player.setFow(Player.getFow() + 2);
					}

					Player.setMoney(Player.getMoney() - localCrew.getCrewMember(index).getPrice());
					localCrew.removeCrewMember(localCrew.getCrewMember(index).getUuid());
				}
			} /*else {
				if (Player.getCrew().canRemove() && localCrew.canAdd()) {
					Player.getCrew().removeCrewMember(Player.getCrew().getCrewMember(index).getUuid());
					localCrew.addCrewMember(localCrew.getCrewMember(index));
					setIcon(null);
				}
			}*/

			dispose();
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}
}
