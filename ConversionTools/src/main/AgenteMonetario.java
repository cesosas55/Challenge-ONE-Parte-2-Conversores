package main;

import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;



public class AgenteMonetario {
	private static String urlInicial = "https://v6.exchangerate-api.com/v6/";
	private static String accessKey = "e014bec508acd3d81a90aeba/latest/";
	private static Divisa moneda;
	InputStream respuesta;
//System.out.println(url+accessKey+moneda.values()[i].toString());

	private URL obtenerURL(String codigo) throws MalformedURLException {
		String linkFinal = urlInicial + accessKey + codigo;
		URL urlFinal = new URL(linkFinal);
		return urlFinal;
	}
	public void hacerSolicitud(String codigo) throws IOException {
		URL address = obtenerURL(codigo);
		HttpURLConnection conexion = (HttpURLConnection) address.openConnection();
		conexion.setRequestMethod("GET");
		conexion.connect();
		respuesta = conexion.getInputStream();
		
	}
	void verDatos() {
	}

}
