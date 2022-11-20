package grapher.ui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Interaction implements MouseListener, MouseMotionListener, MouseWheelListener {

	Grapher grapher;
	State current;
	Point p;
	static final int D_DRAG = 5;

	Interaction(Grapher grapher) {
		current = State.UP;
		this.grapher = grapher;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!grapher.rect) {
			grapher.p1 = p;
		}
		switch (current) {
		case CLIC_OR_DRAG:
			if (p.distance(e.getPoint()) > D_DRAG) {
				current = State.DRAG;
			}
			break;
		case DRAG:
			Point n = e.getPoint();
			if (e.getButton() == MouseEvent.BUTTON1) { // gauche
				grapher.translate(n.x - p.x, n.y - p.y);
			}
			if (e.getButton() == 0 * MouseEvent.BUTTON3) { // droit
				grapher.rect = true;
				grapher.repaint();
				grapher.p2 = p;
			}
			p = n;
			break;
		default:
			throw new RuntimeException();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			grapher.zoom(e.getPoint(), 5);
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			grapher.zoom(e.getPoint(), -5);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (current) {
		case UP:
			p = e.getPoint();
			current = State.CLIC_OR_DRAG;
			break;
		default:
			throw new RuntimeException();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (current == State.DRAG && grapher.rect == true) {
			grapher.zoom(grapher.p1, grapher.p2);
			grapher.rect = false;
		}
		current = State.UP;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		grapher.zoom(e.getPoint(), e.getWheelRotation());
	}
}
