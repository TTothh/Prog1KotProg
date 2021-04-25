package src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class MenuButton extends JButton implements ActionListener{
	private int x;
	private int y;
	private int width = 200;
	private int height = 50;

	public MenuButton(String text) {
		super(text);
		this.addActionListener(this);
	}

	public void setSize(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getSizeX() {
		return this.x;
	}

	public int getSizeY() {
		return this.y;
	}

	@Override
	public abstract void actionPerformed(ActionEvent e);
}
