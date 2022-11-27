package grapher.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolBar extends JPanel implements ActionListener {

	Grapher grapher;
	FunctionsList fList;

	public ToolBar(Grapher grapher, FunctionsList fList) {
		super(new BorderLayout());
		this.grapher = grapher;
		this.fList = fList;
		JToolBar toolBar = new JToolBar("Test toolbar");
		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String newFunction = JOptionPane.showInputDialog("Saisir la nouvelle fonction f(x) :");
				grapher.add(newFunction);
				fList.UpdateValues(grapher.functions);
			}
		});

		JButton minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "Supprimer fonction", "Supprimer fonction",
						JOptionPane.YES_NO_OPTION);
				if (res == 0) {
					grapher.remove(fList.getSelectedValue());
					fList.UpdateValues(grapher.functions);
				}
			}
		});

		toolBar.add(plusButton);
		toolBar.add(minusButton);
		this.add(toolBar);
		toolBar.setFloatable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
