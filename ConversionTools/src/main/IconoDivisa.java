package main;

public enum IconoDivisa {
	MXN("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\MXN.png"),
	USD("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\USD.png"),
	EUR("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\EUR.png"),
	GBP("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\GBP.png"),
	JPY("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\JPY.png"),
	KRW("C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\KRW.png");
	
	public final String iconoUrl;
	
	private IconoDivisa(String url) {
		this.iconoUrl = url;
	}
}
