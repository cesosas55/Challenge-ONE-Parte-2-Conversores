package main;

public enum Divisa {
	MXN("MXN - Peso mexicano", "Pesos Mexicanos"), USD("USD - D�lar estadounidense", "D�lares estadounidenses"),
	EUR("EUR - Euro", "Euros"), GBP("GBP - Libra esterlina", "Libras esterlinas"),
	JPY("JPY - Yen Japon�s", "Yenes japoneses"), KRW("KRW - Won surcoreano", "Wones surcoreanos");

	public final String label;
	public final String nombre;

	private Divisa(String descripcion, String nombrePlural) {
		this.label = descripcion;
		this.nombre = nombrePlural;
	}
}
