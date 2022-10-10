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
		switch (current) {
		case CLIC_OR_DRAG:
			if (p.distance(e.getPoint()) > D_DRAG) {
				current = State.DRAG;
			}
			break;
		case DRAG:
			Point n = e.getPoint();
			if (e.getButton() == MouseEvent.BUTTON1) {
				grapher.translate(n.x - p.x, n.y - p.y);
			}
			if (e.getButton() == MouseEvent.BUTTON3) {
				grapher.zoom(p, n);
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
