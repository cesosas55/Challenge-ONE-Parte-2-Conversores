package main;
/**
 * La clase TestAgenteMonetario fue creada solamente con el propósito de verificar el funcionamiento
 * de la clase TestAgenteMonetario, especialmente el uso de la API y el almacenamiento de la respuesta.
 * 
 * Partes de este código de prueba se utilizaron en las clases que componen el proyecto
 * del conversor.
 * 
 * @author Carlos Enrique Sosa Sánchez
 */
import java.io.IOException;

public class TestAgenteMonetario {
	public static void main(String[] args) throws IOException {
		AgenteMonetario test = new AgenteMonetario();

		InformacionDivisas respuestaApi = new InformacionDivisas();

		respuestaApi = test.hacerSolicitud("MXN");

		double mxnMxn = respuestaApi.getConversionRates().getMxn();
		double mxnUsd = respuestaApi.getConversionRates().getUsd();
		double mxnEur = respuestaApi.getConversionRates().getEur();
		double mxnGbp = respuestaApi.getConversionRates().getGbp();
		double mxnJpy = respuestaApi.getConversionRates().getJpy();
		double mxnKrw = respuestaApi.getConversionRates().getKrw();
		
		double[] valoresIniciales = {mxnMxn, mxnUsd, mxnEur, mxnGbp, mxnJpy, mxnKrw};
		
		test.crearMatrizDivisas(valoresIniciales, true);
		
	}
}
