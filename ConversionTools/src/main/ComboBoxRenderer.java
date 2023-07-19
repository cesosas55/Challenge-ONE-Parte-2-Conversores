package main;

/**
 * La clase ComboBoxRenderer tiene como propo�sito dar formato a las listas desplegables. 
 * Tambi�n se utiliza para agregar los �conos a los elementos de la lista. 
 * 
 * @author Carlos Enrique Sosa S�nchez
 */
import javax.swing.*;
import java.awt.Component;

public class ComboBoxRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;
	private Icon[] iconos;

	/**
	 * Default constructor
	 */
	public ComboBoxRenderer() {
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
	}
/**
 * Constructor con par�metros. permite asignar un valor al atributo de la clase, en este caso un vector. 
 * @param icons - Vector que corresponde a los �conos de las divisas.
 */
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
