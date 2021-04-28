package src.GUI.Screen;

import src.Player;

import javax.swing.*;
import java.awt.*;

public class StatScreen extends JPanel {
	static EnergyBar bar = new EnergyBar();
	public StatScreen() {
		setBounds(0, 30 * 32 + 1, 50 * 32, 100);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		add(bar);
	}

	public void update() {
		bar.setValue(Player.getEnergy());
		bar.setString(String.valueOf(bar.getValue()));
		System.out.println(Player.getEnergy());
	}

	static class EnergyBar extends JProgressBar {
		public EnergyBar() {
			setOrientation(HORIZONTAL);
			setBounds(10, 10, 100, 30);
			setValue(Player.getEnergy());
			setStringPainted(true);
			setString(String.valueOf(getValue()));
		}
	}
}
