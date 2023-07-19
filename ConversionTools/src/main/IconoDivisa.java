package main;
/**
 * El enum IconoDivisa se utiliza para almacenar la dirección de los íconos correspondientes a
 * las divisas que se muestran en la lista desplegable.
 * 
 * @author Carlos Enrique Sosa Sánchez
 */

public enum IconoDivisa {
	MXN("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\MXN.png"),
	USD("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\USD.png"),
	EUR("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\EUR.png"),
	GBP("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\GBP.png"),
	JPY("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\JPY.png"),
	KRW("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\KRW.png");
	
	public final String iconoUrl;
	/**
	 * El constructor permite añadir parámetros a cada uno de los elementos de la divisa. Estos serán
	 * accedidos desde la aplicación para incluir los íconos en las listas desplegables.
	 * 
	 * @param url - Dirección del archivo correspondiente a cada divisa
	 */
	private IconoDivisa(String url) {
		this.iconoUrl = url;
	}
}
