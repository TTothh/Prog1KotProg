package src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExitButton extends MenuButton {
	static MainMenu m;
	public ExitButton(String text) {
		super(text);
	}

	public static void setM(MainMenu m) {
		ExitButton.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.dispose();
	}
}
