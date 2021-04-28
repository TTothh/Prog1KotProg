package src.GUI;

import src.GUI.Screen.CrewScreen;
import src.GUI.Screen.StatScreen;
import src.Game;
import src.Locations.Dock;
import src.NPC.Crew;
import src.Player;
import src.PlayerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JFrame implements KeyListener {
	static PlayerController pc = new PlayerController();

	static JLayeredPane screen = new JLayeredPane();
	static JLabel map = new JLabel();
	static JLabel player = new JLabel();
	static StatScreen stats = new StatScreen();

	public GameScreen() {
	}

	public void Init() {
		addKeyListener(this);

		setTitle("The Peculiar Expedition");
		setSize(50 * 32, (30 * 32) + 100);
		setLayout(null);

		screen.setBounds(0, 0, 50 * 32, (30 * 32) + 100);

		map.setBounds(0, 0, 50 * 32, 30 * 32);
		map.setOpaque(true);

		player.setBackground(new Color(0, 0, 0, 0));
		player.setLocation(Dock.getPosition());
		player.setBounds(Dock.getPosition().y * 32, Dock.getPosition().x * 32, 7, 36);
		player.setOpaque(true);

		add(screen);
		screen.add(map);
		screen.add(player);
		screen.add(stats);

		setResizable(false);
		setVisible(true);

		Game.getExpeditions().get(Game.getCurrentmap()).RevealMap();
		map.setIcon(new ImageIcon(Game.LoadMap()));

		new CrewScreen(new Crew(3));
	}

	public void draw() {
		screen.remove(player);
		screen.remove(map);
		//screen.remove(stats);

		validate();
		repaint();

		map.setIcon(new ImageIcon(Game.LoadMap()));
		player.setIcon(new ImageIcon(Player.getSprite()));
		player.setLocation(Player.getPosition());

		stats.update();

		//screen.add(stats);
		screen.add(player);
		screen.add(map);

		//stats.repaint();
		//stats.revalidate();

		screen.repaint();
		screen.revalidate();

		revalidate();
		repaint();
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
}
