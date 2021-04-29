package src.Events;

import java.awt.*;

/**
 * Nincs implementálva
 */
public class Catastrophe {
	Point center;
	src.Enums.Catastrophe type;

	public Catastrophe(Point center, src.Enums.Catastrophe type) {
		this.center = center;
		this.type = type;
	}
}
