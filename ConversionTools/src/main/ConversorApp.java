package main;

import javax.swing.*;

public class ConversorApp {

	private static String[] possibleValues = { "Divisas", "Temperatura" };

	public static void main(String[] args) {
		//System.out.println("Iniciando aplicación");

		String selectedValue = (String) JOptionPane.showInputDialog(null, "Elige el conversor que deseas utilizas",
				"Challenge ONE - Conversores", JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
				possibleValues[0]);
		//System.out.println("Convertidor elegido: " + selectedValue);
		//System.out.println("Ejecutando la aplicación seleccionada...");

		switch (selectedValue) {
		case "Divisas":
			CurrencyConverterDlg conversorMoneda = new CurrencyConverterDlg();
			conversorMoneda.initDialog();
			break;
		case "Temperatura (PRÓXIMAMENTE)":
			//System.out.println("convertidor de temperatura abierto :)");
			break;
		}

	}
}
