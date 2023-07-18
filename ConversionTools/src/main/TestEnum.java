package main;

public class TestEnum {
	static String divisas[] = new String[Divisa.values().length];
	
	public static void main(String[] args) {
		//Divisa moneda[] = Divisa.values();
		int i=0;
		for (Divisa div : Divisa.values()) {
			//System.out.println(div.label);
			divisas[i]=div.label;
			System.out.println(divisas[i]);
			i++;
		}
		System.out.println(Divisa.values().length);
		
		//Obtiene el equivalente de cada etiqueta en string y lo muestra en la consola
		for (i=0; i< Divisa.values().length; i++) {
			System.out.println("Moneda: " + Divisa.values()[i].toString());
			
		}
		System.out.println(Divisa.MXN.toString());
	}
	
	
	/*
	 * private static String divisas[] = new String[Divisa.values().length];
	private int i = 0;
	 * 
	 * 
	 * // Creación del vector de divisas a partir del enum
		for (Divisa div : Divisa.values()) {
			divisas[i] = div.label;
			i++;
		}
	 */
}
