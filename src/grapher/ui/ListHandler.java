package grapher.ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import grapher.fc.Function;

public class ListHandler implements ListSelectionListener {
	FunctionsList f;
	Grapher grapher;

	ListHandler(FunctionsList f, Grapher grapher) {
		this.f = f;
		this.grapher = grapher;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Function func = (Function) this.f.getSelectedValue();
		int index = grapher.functions.indexOf(func);
		if (grapher.b.contains(true))
			grapher.b.setElementAt(false, grapher.b.indexOf(true));
		grapher.b.setElementAt(true, index);
		grapher.repaint();
	}

}
