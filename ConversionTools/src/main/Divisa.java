package main;

public enum Divisa {
	MXN("Peso mexicano", "Pesos Mexicanos"),
	USD("D�lar estadounidense", "D�lares estadounidenses"),
	EUR("Euro", "Euros"),
	GBP("Libra esterlina", "Libras esterlinas"),
	JPY("Yen Japon�s", "Yenes japoneses"),
	KRW("Won surcoreano", "Wones surcoreanos");

	public final String label;
	public final String nombre;
	

	private Divisa(String descripcion, String nombrePlural) {
		this.label = descripcion;
		this.nombre = nombrePlural;
	}
}
