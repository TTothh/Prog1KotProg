package src.GUI.Screen;

import src.GUI.ClickedListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuScreen extends JFrame implements KeyListener {
	JButton cont = new JButton();
	JButton save = new JButton();
	JButton exit = new JButton();

	public MenuScreen(String title) {
		setTitle(title);
		setSize(300, 300);
		setLayout(new GridBagLayout());

		cont.addMouseListener((ClickedListener) e -> dispose());
		exit.addMouseListener((ClickedListener) e -> ((Window) getRootPane().getParent()).dispose());


		add(cont);
		add(save);
		add(exit);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 27) {
			dispose();
		}
	}
}
