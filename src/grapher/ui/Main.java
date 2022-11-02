/* grapher.ui.Main
 * (c) blanch@imag.fr 2021–2023                                            */

package grapher.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import grapher.fc.Function;

// main that launch a grapher.ui.Grapher

public class Main extends JFrame {
	Main(String title, String[] expressions) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Grapher grapher = new Grapher();

		Interaction interaction = new Interaction(grapher);
		grapher.addMouseListener(interaction);
		grapher.addMouseMotionListener(interaction);
		grapher.addMouseWheelListener(interaction);
		for (String expression : expressions) {
			grapher.add(expression);
		}

		FunctionsList fList = new FunctionsList(grapher.functions, grapher);
		
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, fList, grapher);
		add(pane);
		pack();
	}

	public static void main(String[] argv) {
		final String[] expressions = argv;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main("grapher", expressions).setVisible(true);
			}
		});
	}
}
