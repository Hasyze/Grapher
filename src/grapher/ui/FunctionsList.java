package grapher.ui;

import java.util.Vector;

import javax.swing.JList;

import grapher.fc.Function;

public class FunctionsList extends JList {

	FunctionsList(Vector<Function> functions) {
		super(functions);
	}
}
