package src.Events;

import java.awt.*;

public class Catastrophe {
	Point center;
	src.Enums.Catastrophe type;

	public Catastrophe(Point center, src.Enums.Catastrophe type) {
		this.center = center;
		this.type = type;
	}
}
