package main;

import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;


public class AgenteMonetario {
	static String urlInicial = "https://v6.exchangerate-api.com/v6/";
	static String accessKey = "e014bec508acd3d81a90aeba/pair/";
	static Divisa moneda;
	InputStream respuesta;
//System.out.println(url+accessKey+moneda.values()[i].toString());

	public URL obtenerURL(String codigoIn, String CodigoOut) {
		String linkFinal = urlInicial + accessKey + codigoIn + "/" + CodigoOut;
		URL urlFinal = null;
		try {
			urlFinal = new URL(linkFinal);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlFinal;
	}

	public void hacerSolicitud(String codigoIn, String codigoOut) throws IOException {
		URL address = obtenerURL(codigoIn, codigoOut);
		HttpURLConnection conexion = (HttpURLConnection) address.openConnection();
		conexion.setRequestMethod("GET");
		conexion.connect();
		conexion.getContent();

	}

	void verDatos() {

	}

}
