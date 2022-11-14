/* grapher.ui.Main
 * (c) blanch@imag.fr 2021–2023                                            */

package grapher.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

// main that launch a grapher.ui.Grapher

public class Main extends JFrame {
	Main(String title, String[] expressions) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Grapher grapher = new Grapher();
		Interaction interaction = new Interaction(grapher);

		grapher.setInteraction(interaction);

		grapher.addMouseListener(interaction);
		grapher.addMouseMotionListener(interaction);
		grapher.addMouseWheelListener(interaction);
		for (String expression : expressions) {
			grapher.add(expression);
		}

		FunctionsList fList = new FunctionsList(grapher.functions);
		ToolBar toolb = new ToolBar(grapher, fList);

		JPanel LeftPane = new JPanel(new BorderLayout());
		LeftPane.add(BorderLayout.CENTER, fList);
		LeftPane.add(BorderLayout.SOUTH, toolb);

		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, LeftPane, grapher);
		add(pane);
		pack();

		Menu menu = new Menu(grapher, fList);
		this.setJMenuBar(menu);
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
