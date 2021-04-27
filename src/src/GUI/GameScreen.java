package src.GUI;

import src.Game;
import src.Locations.Dock;
import src.Player;
import src.PlayerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JFrame implements KeyListener {
	PlayerController pc = new PlayerController();

	JLayeredPane screen = new JLayeredPane();
	JLabel map = new JLabel();
	JLabel player = new JLabel();

	public GameScreen() {
		addKeyListener(this);

		setTitle("The Peculiar Expedition");
		setSize(50 * 32, 30 * 32);
		setLayout(null);

		screen.setBounds(0, 0, 50 * 32, 30 * 32);

		map.setIcon(new ImageIcon(Game.LoadMap()));
		map.setBounds(0, 0, 50 * 32, 30 * 32);
		map.setOpaque(true);

		player.setIcon(new ImageIcon(Player.getSprite()));
		player.setBackground(new Color(0, 0, 0, 0));
		player.setLocation(Dock.getPosition());
		player.setBounds(Dock.getPosition().y * 32, Dock.getPosition().x * 32, 7, 36);
		player.setOpaque(true);

		add(screen);
		screen.add(player);
		screen.add(map);

		setResizable(false);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Point pPos = Player.getPosition();
		switch (e.getKeyCode()) {
			case 65 -> pc.move(new Point(pPos.x - 1, pPos.y));    //a
			case 68 -> pc.move(new Point(pPos.x + 1, pPos.y));    //d
			case 87 -> pc.move(new Point(pPos.x, pPos.y - 1));    //w
			case 83 -> pc.move(new Point(pPos.x, pPos.y + 1));    //s
		}

		Point newPos = Player.getPosition();
		player.setLocation((newPos.x * 32) + 10, (newPos.y * 32) - 1);
	}

	/*public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Game.LoadMap(), 50 * 32, 50 * 32, null);
	}*/
}
