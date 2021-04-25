package src.GUI;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
	public GameScreen() {
		setTitle("The Peculiar Expedition");
		setSize(50*32, 30*32);
		setLayout(null);
		setVisible(true);
		setResizable(false);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	}
}
