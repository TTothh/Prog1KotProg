package src;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
	private JPanel mainPanel = new JPanel();
	private JButton button1;

	public GameScreen() {
		super("The Peculiar Expedition");
		SetupElements();
		CreateEventListeners();

		this.setLocationRelativeTo(null);
		this.pack();
		this.setLocation(0, 0);
		this.setVisible(true);
	}

	private void SetupElements() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(mainPanel);
		this.add(button1);
	}

	private void CreateEventListeners() {
		button1.addActionListener(e -> super.dispose());
	}
}
