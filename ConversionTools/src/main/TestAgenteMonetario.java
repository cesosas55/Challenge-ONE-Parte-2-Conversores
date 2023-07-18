package main;

import java.io.IOException;

public class TestAgenteMonetario {
	public static void main(String[] args) throws IOException {
		AgenteMonetario test = new AgenteMonetario();

		InformacionDivisas respuestaApi = new InformacionDivisas();

		respuestaApi = test.hacerSolicitud("MXN");

		//System.out.println(respuestaUsdMxn.getResult());
		//System.out.println("Tipo Entrada: " + respuestaUsdMxn.getBaseCode());
		/*
		System.out.println("MXN - USD: " + respuestaUsdMxn.getConversionRates().getUsd());
		System.out.println("MXN - EUR: " + respuestaUsdMxn.getConversionRates().getEur());
		System.out.println("MXN - GBP: " + respuestaUsdMxn.getConversionRates().getGbp());
		System.out.println("MXN - JPY: " + respuestaUsdMxn.getConversionRates().getJpy());
		System.out.println("MXN - KRW: " + respuestaUsdMxn.getConversionRates().getKrw());*/
		
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
