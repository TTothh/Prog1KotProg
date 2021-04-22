package src;

import java.awt.*;

public class Main {
	public static final int SCREENWIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREENHEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	public static void main(String[] args) {
		Map map = new Map(50, 30);
		map.Generate();
		System.out.println(map);
	}


}