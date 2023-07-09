package main;

import java.io.IOException;

public class TestAgenteMonetario {
	public static void main(String[] args) {
		AgenteMonetario usuario = new AgenteMonetario();
		
		
		try {
			usuario.hacerSolicitud(Divisa.values()[1].toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(usuario.respuesta);
		
	}
}
