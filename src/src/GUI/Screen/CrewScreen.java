package src.GUI.Screen;

import src.Enums.Names;
import src.GUI.ClickedListener;
import src.NPC.Crew;
import src.NPC.NPC;
import src.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Files;
import java.nio.file.Path;

public class CrewScreen extends JFrame {
	protected Crew localCrew;
	JPanel crew1 = new JPanel();
	JPanel crew2 = new JPanel();
	JButton close = new JButton("Accept");

	public CrewScreen(Crew crew) {
		localCrew = crew;
		localCrew.addCrewMember(new NPC(src.Enums.NPC.SCOUT, Names.randomName()));
		localCrew.addCrewMember(new NPC(src.Enums.NPC.SOLDIER, Names.randomName()));
		localCrew.addCrewMember(new NPC(src.Enums.NPC.DONKEY, Names.randomName()));

		setSize(500, 300);
		setBounds(30, 30, 500, 300);
		setName("CrewScreen");
		setLayout(new GridLayout());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		close.setSize(100, 50);
		close.setLocation(390, 240);
		close.addMouseListener((ClickedListener) e -> dispose());

		draw();

		add(crew1);
		add(crew2);
		add(close);

		setVisible(true);
	}

	public void draw() {
		crew1.removeAll();
		crew2.removeAll();

		crew1.setSize(100, 60);
		crew1.setLayout(new FlowLayout());
		crew1.setBounds(10, 10, 100, 60);
		crew1.setBackground(new Color(255, 0, 0, 0));

		for (int i = 0; i < 3; i++) {
			crew1.add(new CrewSlot(false, i));
		}

		crew2.setSize(100, 60);
		crew2.setLayout(new FlowLayout());
		crew1.setBounds(10, 10, 100, 60);
		crew2.setBackground(new Color(0, 255, 0, 0));

		for (int i = 0; i < 3; i++) {
			crew2.add(new CrewSlot(true, i));
		}
	}

	public void Dispose() {
		removeAll();
		setVisible(false);

	}

	class CrewSlot extends JPanel {
		public CrewSlot(boolean isplayerCrew, int index) {
			if (Files.exists(Path.of("/src/src/Assets/GUI/InventorySlot.png"))) {
				//setIcon(new ImageIcon("/src/src/Assets/GUI/InventorySlot.png"));
				setBackground(Color.BLACK);
			}

			setSize(32, 32);
			setLayout(new GridLayout());

			add(new CrewItem(isplayerCrew, localCrew.getCrewMember(index).getSprite(), index));
		}
	}

	class CrewItem extends JLabel implements MouseListener {
		int index = 0;
		boolean isPlayerCrew;

		public CrewItem(boolean isplayerCrew, Image image, int index) {
			this.index = index;
			this.isPlayerCrew = isplayerCrew;

			setIcon(new ImageIcon(image));
			addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(index);
			if (isPlayerCrew) {
				if (localCrew.canRemove() && Player.getCrew().canAdd()) {
					localCrew.removeCrewMember(localCrew.getCrewMember(index).getUuid());
					Player.getCrew().addCrewMember(localCrew.getCrewMember(index));
					setIcon(null);
				}
			} else {
				if (Player.getCrew().canRemove() && localCrew.canAdd()) {
					Player.getCrew().removeCrewMember(Player.getCrew().getCrewMember(index).getUuid());
					localCrew.addCrewMember(localCrew.getCrewMember(index));
					setIcon(null);
				}
			}

			draw();
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
