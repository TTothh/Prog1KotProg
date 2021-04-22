package src;

import javax.swing.*;

public class MainMenu extends JFrame {
	private JPanel panel1;
	private JButton ButtonPlay;
	private JButton ButtonExit;

	public MainMenu() {
		super("Main menu");
		SetupElements();
		CreateEventListeners();

		this.setLocationRelativeTo(null);
		this.pack();
		System.out.println(this.getLocation());
		this.setLocation((Main.SCREENWIDTH / 2 - (this.getSize().width / 2)), (Main.SCREENHEIGHT / 2 - this.getSize().height / 2));
		this.setVisible(true);
	}

	private void SetupElements() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel1);
		this.add(ButtonPlay);
		this.add(ButtonExit);
	}

	private void CreateEventListeners() {
		ButtonPlay.addActionListener(e -> CreateMainScreen());
	}

	private void CreateMainScreen() {
		GameScreen gs = new GameScreen();
	}
}
