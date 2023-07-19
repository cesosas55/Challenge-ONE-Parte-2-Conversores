package main;

/**
 * Este enum se utiliza para controlar el tipo de divisas que se desea utilizar
 * en la aplicaci�n.
 * 
 * @author Carlos Enrique Sosa S�nchez
 */
public enum Divisa {
	MXN("MXN - Peso mexicano", "Pesos Mexicanos"), 
	USD("USD - D�lar estadounidense", "D�lares estadounidenses"),
	EUR("EUR - Euro", "Euros"), 
	GBP("GBP - Libra esterlina", "Libras esterlinas"),
	JPY("JPY - Yen Japon�s", "Yenes japoneses"),
	KRW("KRW - Won surcoreano", "Wones surcoreanos");

	public String label;
	public String nombre;

	/**
	 * El constructor permite a�adir par�metros a cada uno de los elementos de la divisa. Estos ser�n
	 * accedidos desde la aplicaci�n para presentar informaci�n al usuario o para realizar diferentes
	 * c�lculos.
	 * @param descripcion  - Descripci�n de la divisa
	 * @param nombrePlural - Nombre plural de la divisa
	 */
	private Divisa(String descripcion, String nombrePlural) {
		this.label = descripcion;
		this.nombre = nombrePlural;
	}
}
