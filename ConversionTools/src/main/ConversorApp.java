package main;

/**
 * La clase ConversorApp es la clase principal (punto de entrada) de la aplicaci�n. En esta se pregunta
 * al usuario por el tipo de herramienta que desea utilizar mediante un OptionPane y, dependiendo de la
 * respuesta, se ejecuta ventana correspondiente. 
 * 
 * @author Carlos Enrique Sosa S�nchez
 */
import javax.swing.*;

public class ConversorApp {

	private static String[] possibleValues = { "Divisas", "Temperatura" };

	public static void main(String[] args) {
		// System.out.println("Iniciando aplicaci�n");

		String selectedValue = (String) JOptionPane.showInputDialog(null, "Elige el conversor que deseas utilizas",
				"Challenge ONE - Conversores", JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
				possibleValues[0]);
		/**
		 * Se tienen dos opciones en la ventana: Conversi�n de divisas y de temperatura.
		 * De momento solo la conversi�n de divisas ha sido implementada.
		 */
		switch (selectedValue) {
		case "Divisas":
			CurrencyConverterDlg conversorMoneda = new CurrencyConverterDlg();
			conversorMoneda.initDialog();
			break;
		case "Temperatura":
			// System.out.println("convertidor de temperatura abierto :)");
			break;
		}

	}
}
