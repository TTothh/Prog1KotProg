package src.GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
	public MainMenu() {
		ExitButton exit = new ExitButton("Exit");
		NewGame ng = new NewGame("New Game");

		setTitle("The Peculiar Expedition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(420, 420);
		setVisible(true);
		setLayout(null);
		setBackground(Color.darkGray);

		ng.setSize(200, 50);
		ng.setBounds(getWidth() / 2 - ng.getSizeX() / 2, getHeight() / 2 - ng.getSizeY(), ng.getSizeX(), ng.getSizeY());

		exit.setSize(200, 50);
		exit.setBounds((this.getWidth() / 2) - (exit.getSizeX() / 2), (this.getHeight() - 100) - (exit.getSizeY()), exit.getSizeX(), exit.getSizeY());
		ExitButton.setM(this);

		add(ng);
		add(exit);
	}

	public void Dispose() {
		dispose();
	}
}
