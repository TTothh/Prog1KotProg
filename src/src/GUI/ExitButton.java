package src.GUI;

import java.awt.event.ActionEvent;

/**
 * Bezárja a mainscreent
 */

public class ExitButton extends MenuButton {
	static MainMenu m;
	public ExitButton(String text) {
		super(text);
	}

	/**
	 * Átadom a mainmenu-t paraméterben és click-re dispose-olom
	 * @param m
	 */
	public static void setM(MainMenu m) {
		ExitButton.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.dispose();
	}
}
