import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;

public class Main {
	public static final int SCREENWIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREENHEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	public static void main(String[] args) {
		Map map = new Map(50, 30);
		map.Generate();
		System.out.println(map);
	}


}
