package main;
/**
 * La clase COnversionRates se utiliza como parte de la deserialización de la respuesta en formato JSON de la 
 * API de Exchange-API.
 * los atributos de esta clase corresponden a los valores de tipo de cambio para las monedas consideradas en
 * el proyecto. Los getters/setters se utilizan para que el objeto Gson pueda mapear desde el Json hasta este
 * objeto y posteriormente obtener los datos en la aplicación.
 * 
 * @author Carlos Enrique Sosa Sánchez
 */
import com.google.gson.annotations.*;

public class ConversionRates {

	@SerializedName("MXN")
	@Expose
	private Double mxn;
	
	@SerializedName("USD")
	@Expose
	private Double usd;
	
	@SerializedName("EUR")
	@Expose
	private Double eur;
	
	@SerializedName("GBP")
	@Expose
	private Double gbp;
	
	@SerializedName("JPY")
	@Expose
	private Double jpy;
	
	@SerializedName("KRW")
	@Expose
	private Double krw;

	public Double getMxn() {
		return mxn;
	}

	public void setMxn(Double mxn) {
		this.mxn = mxn;
	}

	public Double getUsd() {
		return usd;
	}

	public void setUsd(Double usd) {
		this.usd = usd;
	}

	public Double getEur() {
		return eur;
	}

	public void setEur(Double eur) {
		this.eur = eur;
	}

	public Double getGbp() {
		return gbp;
	}

	public void setGbp(Double gbp) {
		this.gbp = gbp;
	}

	public Double getJpy() {
		return jpy;
	}

	public void setJpy(Double jpy) {
		this.jpy = jpy;
	}

	public Double getKrw() {
		return krw;
	}

	public void setKrw(Double krw) {
		this.krw = krw;
	}
	
}
