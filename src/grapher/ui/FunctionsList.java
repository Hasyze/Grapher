package grapher.ui;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import grapher.fc.Function;

public class FunctionsList extends JList {

	FunctionsList(Vector<Function> functions, Grapher g) {
		super(functions);
		this.addListSelectionListener(new ListHandler(this, g));
	}


	void UpdateValues(Vector<Function> functions) {
		this.removeAll();
		this.setListData(functions);
	}
}
