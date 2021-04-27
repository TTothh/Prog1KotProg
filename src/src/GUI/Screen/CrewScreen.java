package src.GUI.Screen;

import src.Enums.Names;
import src.NPC.Crew;
import src.NPC.NPC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CrewScreen extends JPanel {
	Crew crew = new Crew(3);

	public CrewScreen() {
		crew.addCrewMember(new NPC(src.Enums.NPC.SCOUT, Names.randomName()));
		crew.addCrewMember(new NPC(src.Enums.NPC.SOLDIER, Names.randomName()));
		crew.addCrewMember(new NPC(src.Enums.NPC.DONKEY, Names.randomName()));

		JPanel crew1 = new JPanel();
		JPanel crew2 = new JPanel();
		JButton close = new JButton("Accept");

		setSize(300, 100);
		setBounds(30, 30, 500, 300);
		setBackground(new Color(0, 0, 0, (float) 0.3));
		setName("CrewScreen");
		setBorder(null);

		setLayout(new BorderLayout());

		crew1.setSize(100, 60);
		crew1.setLayout(new FlowLayout());
		crew1.setLocation(10, 10);
	}

	class CrewSlot extends JLabel {
		public CrewSlot() {
		}
	}

	class CrewItem extends JLabel implements MouseListener {
		public CrewItem(Icon image) {
			setIcon(image);
			addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {

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
