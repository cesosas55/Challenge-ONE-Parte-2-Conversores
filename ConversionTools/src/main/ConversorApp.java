package main;

import javax.swing.*;

public class ConversorApp {

	private static String[] possibleValues = { "Divisas", "Temperatura" };

	public static void main(String[] args) {
		//System.out.println("Iniciando aplicaci�n");

		String selectedValue = (String) JOptionPane.showInputDialog(null, "Elige el conversor que deseas utilizas",
				"Challenge ONE - Conversores", JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
				possibleValues[0]);
		//System.out.println("Convertidor elegido: " + selectedValue);
		//System.out.println("Ejecutando la aplicaci�n seleccionada...");

		switch (selectedValue) {
		case "Divisas":
			CurrencyConverterDlg conversorMoneda = new CurrencyConverterDlg();
			conversorMoneda.initDialog();
			break;
		case "Temperatura (PR�XIMAMENTE)":
			//System.out.println("convertidor de temperatura abierto :)");
			break;
		}

	}
}
