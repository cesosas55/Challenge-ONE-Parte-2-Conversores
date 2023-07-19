package main;
/**
 * La clase InformacionDivisas es utilizada como parte de la tarea de deserialización de la respuesta en
 * formato JSON de la API de Exchange-API. Esta permite almacenar el resultado de la solicitud y el código
 * base utilizado para esta. 
 * 
 * Además, el atributo ConversionRates es un objeto donde se almacenan los valores de tipo de cambio para
 * las distintas divisas disponibles tomando como punto de partida la divisa base que se especifique en la
 * solicitud. 
 * 
 * @author Carlos Enrique Sosa Sánchez. 
 */
import com.google.gson.annotations.*;

public class InformacionDivisas {

	@SerializedName("result")
	@Expose
	private String result;

	@SerializedName("base_code")
	@Expose
	private String baseCode;

	@SerializedName("conversion_rates")
	@Expose
	private ConversionRates conversionRates;

	public InformacionDivisas() {// Default constructor

	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String getBaseCode() {
		return baseCode;
	}
	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}

	public ConversionRates getConversionRates() {
		return conversionRates;
	}
	public void setConversionRates(ConversionRates conversionRates) {
		this.conversionRates = conversionRates;
	}

}
