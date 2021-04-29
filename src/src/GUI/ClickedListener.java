package src.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Interface azért hogy a MouseListenert lehessen lambában is létrehozni. A mouseclicked hiányzik így lambdánál automatikusan annak fogja venni a létrejött eventlistenert
 * Explanation: https://stackoverflow.com/questions/36603123/functional-interface-in-java-to-react-on-mouseclick
 */

public interface ClickedListener extends MouseListener {
	@Override
	public default void mouseEntered(MouseEvent e) {}

	@Override
	public default void mouseExited(MouseEvent e) {}

	@Override
	public default void mousePressed(MouseEvent e) {}

	@Override
	public default void mouseReleased(MouseEvent e) {}

}
