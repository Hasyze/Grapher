package grapher.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu extends JMenuBar {
	JMenu menu;
	JMenuItem menuItemAdd, menuItemRemove;

	Grapher grapher;
	FunctionsList fList;

	Menu(Grapher grapher, FunctionsList fList) {
		super();
		menu = new JMenu("Expression");
		this.add(menu);
		menuItemAdd = new JMenuItem("Ajouter");
		menuItemAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String newFunction = JOptionPane.showInputDialog("Saisir la nouvelle fonction f(x) :");
				grapher.add(newFunction);
				fList.UpdateValues(grapher.functions);
			}

		});
		menuItemRemove = new JMenuItem("Supprimer");
		menuItemRemove.addActionListener(new ActionListener() {

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
		menu.add(menuItemAdd);
		menu.add(menuItemRemove);
	}
}
