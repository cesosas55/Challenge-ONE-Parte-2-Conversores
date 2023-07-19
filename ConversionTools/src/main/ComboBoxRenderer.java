package main;

/**
 * La clase ComboBoxRenderer tiene como propoósito dar formato a las listas desplegables. 
 * También se utiliza para agregar los íconos a los elementos de la lista. 
 * 
 * @author Carlos Enrique Sosa Sánchez
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer {

	private static final long serialVersionUID = 1L;
	private ImageIcon[] iconos;
	private String[] textoDivisa;
	private Font uhOhFont;

	public ComboBoxRenderer(ImageIcon[] iconos, String[] texto) {
		this.iconos = iconos;
		this.textoDivisa = texto;

		setOpaque(true);
		setHorizontalAlignment(LEADING);
		setVerticalAlignment(CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// Get the selected index. (The index param isn't
		// always valid, so just use the value.)
		int selectedIndex = ((Integer) value).intValue();

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		// Set the icon and text. If icon was null, say so.
		ImageIcon icon = iconos[selectedIndex];
		String divisa = textoDivisa[selectedIndex];
		setIcon(icon);
		if (icon != null) {
			setText(divisa);
			setFont(list.getFont());
		} else {
			setUhOhText(divisa, list.getFont());
		}
		return this;
	}

	// Set the font and text when no image was found.
	protected void setUhOhText(String uhOhText, Font normalFont) {
		if (uhOhFont == null) { // lazily create this font
			uhOhFont = normalFont.deriveFont(Font.ITALIC);
		}
		setFont(uhOhFont);
		setText(uhOhText);
	}
}