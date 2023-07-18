package main;

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
