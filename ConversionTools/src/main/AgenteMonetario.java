package main;

/**
 * La clase AgenteMonetario tiene como propósito manejar la comunicación entre la aplicación
 * del conversor de divisas y la API de Exchange-API. Esta se encarga de realizar las
 * operaciones necesarias para realizar la solicitud a la API y manejar la respuesta.
 * 
 * Además, para optimizar el uso de la API, los datos de tipo de cambio para las diversas divisas
 * se calculan y almacenan en una matriz. De este modo, la consulta solo se realiza en el arranque
 * de la aplicación y no cada que se desea obtener un resultado. 
 * 
 * Se consideran los siguientes atributos:
 * 		urlInicial 			- Parte de la url para llamar a la API
 * 		accessKey 			- Llave proporcionada por Exchange-API para acceer a la información
 * 		cantidadDivisas 	- Número de divisas que maneja la aplicación 
 * 		matrizTipoDeCambio	- Matriz conformada por el tipo de cambio a pesos mexicanos y sus equivalencias
 * 
 * @author Carlos Enrique Sosa Sánchez
 */
import java.net.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AgenteMonetario {
	private final String urlInicial = "https://v6.exchangerate-api.com/v6/";
	private final String accessKey = "e014bec508acd3d81a90aeba/latest/";

	private int cantidadDivisas = Divisa.values().length;
	private double[][] matrizTipoDeCambio = new double[cantidadDivisas][cantidadDivisas];

	/**
	 * Utilizado para componer la url que utilizará la aplicación para llamar a la
	 * API.
	 * 
	 * @param codigoBase - Código de la divisa que se tomará como base para el tipo
	 *                   de cambio
	 * @return
	 */
	public URL obtenerURL(String codigoBase) {
		String linkFinal = urlInicial + accessKey + codigoBase;
		URL urlFinal = null;
		try {
			urlFinal = new URL(linkFinal);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return urlFinal;
	}

	/**
	 * Realiza la conexión a la API mediante el protocolo HTTP y almacena los datos
	 * de la respuesta en un objeto de tipo InformacionDivisas.
	 * 
	 * @param codigoIn - - Código de la divisa que se tomará como base para el tipo
	 *                 de cambio
	 * @return
	 */
	public InformacionDivisas hacerSolicitud(String codigoIn) {
		// Creamos la URL
		URL address = obtenerURL(codigoIn);
		// Inciamos la conexión
		HttpURLConnection conexion = null;
		InformacionDivisas tipoDeCambio = null;
		try {
			// Abre la conexión
			conexion = (HttpURLConnection) address.openConnection();
			// set request method
			conexion.setRequestMethod("GET");
			// get response code
			int responseCode = conexion.getResponseCode();
			// Si el código es correcto, recolectamos los datos
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				StringBuilder respuesta = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					respuesta.append(line);
				}
				reader.close();
				String respuestaBody = respuesta.toString();
				// System.out.println(respuestaBody); // Check the incoming JSON response
				// Deserialize JSON using GSON
				Gson gj = new Gson();
				tipoDeCambio = gj.fromJson(respuestaBody, InformacionDivisas.class);
				conexion.getInputStream().close();
				// System.out.println("Datos guardados");
			} else {
				System.out.println("Código incorrecto");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				conexion.disconnect();
			}
		}
		return tipoDeCambio;
	}

	/**
	 * Se utiliza para calcular los valores de cada uno de los elementos de la
	 * matriz de tipo de cambio.
	 * 
	 * @param valoresAPI - vector conformado por los valores obtenidos de la
	 *                   respuesta de la API
	 * @param verMatriz  - define si desea ver el resultado en la terminal
	 */
	public void crearMatrizDivisas(double[] valoresAPI, boolean verMatriz) {
		if (valoresAPI.length != cantidadDivisas) {
			System.out.println("El vector de coeficientes no es del mismo tamaño que la lista de divisas");
		} else {
			// Agregamos los tipos de cambio de la API a la primera columna de la matriz.
			for (int i = 0; i < cantidadDivisas; i++) {
				// Agregamos los tipos de cambio de la API a la primera columna de la matriz.
				matrizTipoDeCambio[0][i] = valoresAPI[i];
				// calculamos el inverso y lo colocamos en la primera fila
				matrizTipoDeCambio[i][0] = 1.0 / valoresAPI[i];
			}
			// calculamos los coeficientes del resto de la matriz
			for (int i = 1; i < cantidadDivisas; i++) {
				for (int j = 1; j < cantidadDivisas; j++) {
					if (i == j) {// Si los indices son iguales, el valor será 1
						matrizTipoDeCambio[i][j] = 1.0;
					} else {
						matrizTipoDeCambio[i][j] = matrizTipoDeCambio[0][j] * matrizTipoDeCambio[i][0];
					}
				}
			}
		}
		if (verMatriz) {
			for (int i = 0; i < cantidadDivisas; i++) {
				for (int j = 0; j < cantidadDivisas; j++) {
					System.out.print(matrizTipoDeCambio[i][j] + ",  ");
				}
				System.out.println("\n");
			}
		}

	}

	/**
	 * Permite realizar el llamado a la API para obtener los valores de tipo de cambio y
	 * crear la matriz correspondiente para calcular las conversiones que se realicen.
	 * @param codigo
	 */
	public void crearCacheMxn(String codigo) {
		InformacionDivisas respuestaApi = new InformacionDivisas();

		respuestaApi = hacerSolicitud(codigo);

		double mxnMxn = respuestaApi.getConversionRates().getMxn();
		double mxnUsd = respuestaApi.getConversionRates().getUsd();
		double mxnEur = respuestaApi.getConversionRates().getEur();
		double mxnGbp = respuestaApi.getConversionRates().getGbp();
		double mxnJpy = respuestaApi.getConversionRates().getJpy();
		double mxnKrw = respuestaApi.getConversionRates().getKrw();

		double[] valoresIniciales = { mxnMxn, mxnUsd, mxnEur, mxnGbp, mxnJpy, mxnKrw };

		crearMatrizDivisas(valoresIniciales, false);
	}

	public double getTipoCambio(int desdeMoneda, int aMoneda) {
		return matrizTipoDeCambio[desdeMoneda][aMoneda];
	}
}
