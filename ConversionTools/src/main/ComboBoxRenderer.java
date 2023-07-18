package main;

import javax.swing.*;
import java.awt.Component;

public class ComboBoxRenderer extends DefaultListCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Icon[] iconos;

	public ComboBoxRenderer() {
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
	}

	public ComboBoxRenderer(Icon[] icons) {
		this.iconos = icons;
	}

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		if (index >= 0 && index < iconos.length) {
			label.setIcon(iconos[index]);
		} else {
			label.setIcon(null);
		}
		return label;

	}
}
