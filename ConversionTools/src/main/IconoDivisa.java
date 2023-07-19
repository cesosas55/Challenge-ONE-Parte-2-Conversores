package main;
/**
 * El enum IconoDivisa se utiliza para almacenar la direcci�n de los �conos correspondientes a
 * las divisas que se muestran en la lista desplegable.
 * 
 * @author Carlos Enrique Sosa S�nchez
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
	 * El constructor permite a�adir par�metros a cada uno de los elementos de la divisa. Estos ser�n
	 * accedidos desde la aplicaci�n para incluir los �conos en las listas desplegables.
	 * 
	 * @param url - Direcci�n del archivo correspondiente a cada divisa
	 */
	private IconoDivisa(String url) {
		this.iconoUrl = url;
	}
}
