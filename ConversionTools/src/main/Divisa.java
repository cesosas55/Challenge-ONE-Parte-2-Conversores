package main;

/**
 * Este enum se utiliza para controlar el tipo de divisas que se desea utilizar
 * en la aplicación.
 * 
 * @author Carlos Enrique Sosa Sánchez
 */
public enum Divisa {
	MXN("MXN - Peso mexicano", "Pesos Mexicanos"), 
	USD("USD - Dólar estadounidense", "Dólares estadounidenses"),
	EUR("EUR - Euro", "Euros"), 
	GBP("GBP - Libra esterlina", "Libras esterlinas"),
	JPY("JPY - Yen Japonés", "Yenes japoneses"),
	KRW("KRW - Won surcoreano", "Wones surcoreanos");

	public String label;
	public String nombre;

	/**
	 * El constructor permite añadir parámetros a cada uno de los elementos de la divisa. Estos serán
	 * accedidos desde la aplicación para presentar información al usuario o para realizar diferentes
	 * cálculos.
	 * @param descripcion  - Descripción de la divisa
	 * @param nombrePlural - Nombre plural de la divisa
	 */
	private Divisa(String descripcion, String nombrePlural) {
		this.label = descripcion;
		this.nombre = nombrePlural;
	}
}
